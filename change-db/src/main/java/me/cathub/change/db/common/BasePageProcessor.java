package me.cathub.change.db.common;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public abstract class BasePageProcessor implements PageProcessor {
    protected Site site;

    public BasePageProcessor(String referer) {
        site = Site.me().setRetryTimes(3).setSleepTime(80000).setTimeOut(10000)
                .setUserAgent(Constant.COMMON_USER_AGENT_PHONE)
                .addHeader("cookie", Constant.ALIBABA_COOKIE)
                .addHeader("referer", referer);
    }
}
