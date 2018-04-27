package me.cathub.change.db.processor;

import me.cathub.change.db.bean.Product;
import me.cathub.change.db.common.BasePageProcessor;
import me.cathub.change.db.common.Constant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业:爬取产品 and 产品链接
 */
public class CompanyPageProcessor extends BasePageProcessor {
    @Override
    public void process(Page page) {
        String company_name = page.getHtml().$("head > title").$("title", "text").get();
        company_name = company_name.substring(0, company_name.indexOf("_"));

        List<String> product_urls = page.getHtml().$("div.app-offerGeneral > div > div > ul > li > div.image").$("a", "href").all();
        List<String> product_names = page.getHtml().$("div.app-offerGeneral > div > div > ul > li > div.image").$("a", "title").all();
        List<String> product_prices = page.getHtml().$("div.app-offerGeneral > div > div > ul > li > div").$("em", "text").all();
        List<String> product_image_urls = page.getHtml().$("div.app-offerGeneral > div > div > ul > li > div.image").$("img", "data-lazy-load-src").all();

        if (product_image_urls.size() != product_names.size() || product_image_urls.size() != product_prices.size() || product_image_urls.size() != product_urls.size())
            return;

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < product_urls.size(); i++) {
            Product product = new Product();
            product.setCompany_name(company_name);
            product.setName(product_names.get(i));
            product.setUrl(product_urls.get(i));
            product.setPrice(Float.parseFloat(product_prices.get(i)));
            product.setImage_url(product_image_urls.get(i));

            products.add(product);
        }
        page.putField("products", products);
        System.out.println("INFO : LENGTH:" + products.size());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CompanyPageProcessor())
                .addUrl(Constant.$9)
                .addPipeline(new JsonFilePipeline("C:\\Users\\cheng\\Desktop\\DATA\\products"))
                .thread(8)
                .run();
    }
}
