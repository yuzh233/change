package me.cathub.change.db.collection.processor;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import me.cathub.change.api.dao.user.CompanyDao;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.db.collection.BasePageProcessor;
import me.cathub.change.user.bean.Company;
import me.cathub.change.user.dao.CompanyDaoImpl;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductListPageProcessor extends BasePageProcessor<List> {

    static CompanyDao companyDao;
    static Sequence sequence = new Sequence(1, 0);

    static Map<String, String> urls = new HashMap();

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

//                    urls.put(url);
//                    Company company = new Company();
//                    String name = (String) row.get(0);
//                    String server = (String) row.get(2);
//                    String address = (String) row.get(3);
//
//                    company.setId(sequence.nextId());
//                    company.setName(name);
//                    company.setService(server.trim().replace(";", ""));
//                    company.setAddress(address);
//                    company.setTableIndex(0);
//                    companyDao.insert(company);
//                    System.out.println(company);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-user-dao.xml");
        companyDao = context.getBean(CompanyDaoImpl.class);
        init();
    }
}