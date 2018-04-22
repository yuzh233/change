package me.cathub.change.db.collection.processor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import me.cathub.change.db.collection.BasePageProcessor;
import me.cathub.change.db.collection.Constant;
import me.cathub.change.db.collection.tool.HTTPTools;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业列表抓取
 */
public class CompanyListPageProcessor extends BasePageProcessor<List> {
    private String fileName;
    static String[] keys = {"飞机杯"};
    static String PAGE_URL = "https://s.1688.com/company/company_search.htm?keywords=";

    public CompanyListPageProcessor(String indexUrl) {
        super(indexUrl, new ArrayList());
    }

    @Override
    public void processor(Document document, List data) {
        setFileName(document.select("#q").attr("value"));

        Elements company_names = document.select("div.list-item-left > div.wrap > div.list-item-title > a.list-item-title-text");
        Elements company_server = document.select("div.list-item-left > div.wrap > div.list-item-detail > div.detail-left > div.detail-float-items > a");
        Elements company_address = document.select("div.list-item-left > div.wrap > div.list-item-detail > div.detail-left > div:nth-child(2) > a");

        data.add(CollUtil.newArrayList(Constant.EXCEL_COMPANY_HEADS));

        for (int i = 0; i < company_names.size() && i < company_server.size() && i < company_address.size(); i++) {
            System.out.println("name:" + company_names.get(i).attr("title") + " url:" + company_names.get(i).attr("href") + " server:" + company_server.get(i).text() + " address:" + company_address.get(i).attr("title"));
            ArrayList<String> row = new ArrayList<>();
            row.add(company_names.get(i).attr("title"));
            row.add(company_names.get(i).attr("href"));
            row.add(company_server.get(i).text());
            row.add(company_address.get(i).attr("title"));

            data.add(row);
        }
    }

    @Override
    public void result(List data) {
        ExcelWriter writer = ExcelUtil.getWriter(Constant.DEFAULT_PATH + getFileName());
        writer.write(data);
        writer.close();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName + ".xlsx";
    }

    public static void main(String[] args) throws Exception {
//        for (String key : keys) {
//            new CompanyListPageProcessor(PAGE_URL + HTTPTools.urlEncode(key)).start();
//        }
        System.out.println(HTTPTools.getHtml("https://anluoqi.1688.com/?spm=b26110380.2178313.result.1.67675a5bVqOT0i"));
    }
}
