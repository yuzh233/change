package me.cathub.change.db.collection;


import org.jsoup.nodes.Document;

public interface PageProcessor<D> {
    /**
     * 解析页面的方法
     * @param document
     */
    void processor(Document document, D data);

    /**
     * 处理结果的模板方法
     * @param data
     */
    public void result(D data);
}
