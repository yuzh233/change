package me.cathub.change.db.collection.processor;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import me.cathub.change.db.collection.BasePageProcessor;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.user.bean.Company;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductListPageProcessor extends BasePageProcessor<List> {

    @Autowired
    static CompanyCurd companyCurd;

    static List<String> urls = new ArrayList<>();

    public ProductListPageProcessor() {
    }

    public ProductListPageProcessor(String indexUrl) {
        super(indexUrl, new ArrayList());
    }

    @Override
    public void processor(Document document, List data) {

    }

    @Override
    public void result(List data) {

    }

    public static void init() throws Exception {
        String path = "C:\\Users\\cheng\\Desktop\\git\\data\\日用品";
        File[] files = new File(path).listFiles();
        for (File file : files) {
            ExcelReader reader = ExcelUtil.getReader(file);
            List<List<Object>> rows = reader.read();
            for (List<Object> row : rows) {
                if (row.size() > 3) {
                    String url = (String) row.get(1);
                    if (! url.contains("http"))
                        continue;

                    Company company = new Company();
                    String name = (String) row.get(0);
                    String server = (String) row.get(2);
                    String address = (String) row.get(3);

                    company.setName(name);
                    company.setService(server);
                    company.setAddress(address);
                    companyRpcServer.insert(company);
                    System.out.println(company);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring.xml");
        init();
    }
}
