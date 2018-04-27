package me.cathub.change.db.processor;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

public class ProductPcPageProcessor extends ProductPageProcessor {

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml());
    }

    public static void main(String[] args) {
        Spider.create(new ProductMPageProcessor())
                .addUrl("https://detail.1688.com/offer/567864221984.html?smToken=c52c8368fe5f477cb15ff9a2475fa763&smSign=MVvuRydlqxKrinhT0g9vIw%3D%3D")
                .addPipeline(new JsonFilePipeline("C:\\Users\\cheng\\Desktop\\DATA\\product_info\\"))
                .thread(8)
                .run();
    }
}
