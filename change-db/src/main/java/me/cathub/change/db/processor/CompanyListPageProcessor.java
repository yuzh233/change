package me.cathub.change.db.processor;

import me.cathub.change.db.common.BasePageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 分类企业:爬取企业 and 企业链接
 */
public class CompanyListPageProcessor extends BasePageProcessor implements PageProcessor {

    public CompanyListPageProcessor(String referer) {
        super(referer);
    }

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CompanyListPageProcessor(""))
                .addUrl("https://kj.1688.com/nvzhuang2.html?spm=a262gg.8864560.j3phhv0x.1.3a886510Q5yWUI")
                .addPipeline(new JsonFilePipeline("C:\\Users\\cheng\\Desktop\\DATA"))
                .thread(5)
                .run();
    }
}
