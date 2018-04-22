package me.cathub.change.db.collection;


import me.cathub.change.db.collection.tool.HTTPTools;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class BasePageProcessor<D> implements PageProcessor<D> {
    private String indexUrl;
    private Document document;
    private D data;

    public BasePageProcessor() {
    }

    public BasePageProcessor(String indexUrl, D data) {
        this.indexUrl = indexUrl;
        this.data = data;
        try {
            document = Jsoup.parse(HTTPTools.getHtml(indexUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行
     */
    public final void start() {
        processor(document, data);
        result(data);
    }
}
