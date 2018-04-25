package me.cathub.change.common.tool.aliyunoss;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class OssTools {
    private static final String BUCKET_NAME = "change-data";
    private static final String ACCESS_KEY_ID = "LTAIedWOs9wiM17u";
    private static final String ACCESS_KEY_SECRET = "a3xVvP9ELRp6Tp6HeTzVgwcUScgmm2";
    private static final String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";
    private static final OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

    public static void uploadResource(String save_path, String obj_name, InputStream inputStream) {
        ossClient.putObject(BUCKET_NAME, save_path + "/" + obj_name, inputStream);
    }
}
