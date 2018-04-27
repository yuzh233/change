package me.cathub.change.db.processor;

import me.cathub.change.db.bean.Category;
import me.cathub.change.db.common.BasePageProcessor;
import me.cathub.change.db.common.Constant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页:爬取分类 and 分类链接
 */
public class IndexPageProcessor extends BasePageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        List<String> category_urls = page.getHtml().xpath("/html/body/div[3]/div[3]/div/div/div/div/div/ul/li/div/a").links().all();
        List<String> category_names = page.getHtml().xpath("/html/body/div[3]/div[3]/div/div/div/div/div/ul/li/div/a").$("a", "text").all();

        List<Category> categorys = new ArrayList<>();
        for (int i = 0; i < category_names.size(); i++) {
            Category category = new Category();
            category.setName(category_names.get(i));
            category.setUrl(category_urls.get(i));

            categorys.add(category);
        }

        page.putField("categorys", categorys);
        System.out.println("LENGTH :" + categorys.size());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new IndexPageProcessor())
                .addUrl("https://kj.1688.com/?spm=a260k.635.jdlmjgub.5.6883436chpWfGO")
                .addPipeline(new JsonFilePipeline("C:\\Users\\cheng\\Desktop\\DATA\\categorys"))
                .thread(5)
                .run();
    }
}
