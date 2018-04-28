package me.cathub.change.db.processor;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import me.cathub.change.db.bean.Product;
import me.cathub.change.db.bean.ProductImage;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductMPageProcessor extends ProductPageProcessor {

    public ProductMPageProcessor(String referer) {
        super(referer);
    }

    @Override
    public void process(Page page) {
        String temp = page.getHtml().regex("\"companyName\":\"[\\u4e00-\\u9fa5]+\"").get();
        temp = temp.substring(0, temp.lastIndexOf("\""));
        String company_name = temp.substring(temp.lastIndexOf("\"", temp.length()) + 1);

        String price = page.getHtml().$("div.d-content.fd-clr > div > dl.d-price-discount.nobottom > dd").$("dd", "text").get();

        String product_name = page.getHtml().$("div.wing-view-title > div > div > h1 > span").$("span", "text").get();

        List<String> cover_images = page.getHtml().$("#d-swipe > div > div > img").$("img", "swipe-lazy-src").all();
        List<String> info_images = page.getHtml().$("div.swipe-pane > img").$("img", "swipe-lazy-src").all();

        Product product = new Product();
        price = price.trim().substring(0, price.indexOf(" "));
        product.setPrice(Float.parseFloat(price));
        product.setName(product_name);
        product.setCompany_name(company_name);

        List<ProductImage> images = new ArrayList<>();
        for (int i = 0; i < cover_images.size(); i++) {
            ProductImage productImage = new ProductImage();
            productImage.setUrl(cover_images.get(i));
            productImage.setType(ProductImage.TYPE_SHOW);
            images.add(productImage);
        }

        for (int i = 0; i < info_images.size(); i++) {
            ProductImage productImage = new ProductImage();
            productImage.setUrl(info_images.get(i));
            productImage.setType(ProductImage.TYPE_INFO);
            images.add(productImage);
        }
        product.setImages(images);
        page.putField("product", product);
        System.out.println("SUCCEE : " + product);
    }

    public static void main(String[] args) {
//        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
//        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
//                new Proxy("47.89.10.103",80)
//        ));

        try {
            File category = new File(ProductMPageProcessor.class.getResource("/data/products/girl").getPath());

                File[] jsonFiles = category.listFiles();

                List<Product> products = new ArrayList<>();
                for (File jsonFile: jsonFiles) {
                    JSONObject jsonObject = JSONUtil.readJSONObject(jsonFile, Charset.defaultCharset());

                    JSONArray jsonProducts = JSONUtil.parseArray(jsonObject.get("products"));
                    for (Object jsonProduct : jsonProducts) {
                        Product temp = JSONUtil.toBean(jsonProduct.toString(), Product.class);

                        products.add(temp);
                    }
                }
                List<String> list = products.stream().map(product -> m(product.getUrl())).collect(toList());
                String[] urls = list.toArray(new String[list.size()]);


            for (String url:urls) {
                Spider.create(new ProductMPageProcessor(url))
                        .addUrl(url)
                        .addPipeline(new JsonFilePipeline("C:\\Users\\cheng\\Desktop\\DATA\\data\\" + category.getName()))
                        .thread(8)
                        .run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
