package me.cathub.change.db.processor;

import me.cathub.change.db.common.BasePageProcessor;
import us.codecraft.webmagic.Site;

/**
 * 产品:爬取产品详细信息
 */
public abstract class ProductPageProcessor extends BasePageProcessor {

    public ProductPageProcessor(String referer) {
        super(referer);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static String m(String url) {
        return url.replace("detail", "m");
    }
}
