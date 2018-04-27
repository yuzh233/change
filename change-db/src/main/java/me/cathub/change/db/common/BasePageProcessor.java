package me.cathub.change.db.common;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public abstract class BasePageProcessor implements PageProcessor {
    protected Site site;

    public BasePageProcessor() {
        site = Site.me().setRetryTimes(3).setSleepTime(80000).setTimeOut(10000)
                .setUserAgent(Constant.ALIBABA_COOKIE)
                .addHeader("cookie", Constant.COMMON_USER_AGENT_PC)
                .addHeader("referer", Constant.REFERER);
    }
}
