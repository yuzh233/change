package me.cathub.change.common.tool.aliyun;

import com.aliyun.oss.OSSClient;
import me.cathub.change.common.tool.HTTPTool;
import me.cathub.change.common.tool.Sequence;

import java.io.InputStream;

public class OSSAPI {
    private static final String BUCKET_NAME = "change-data";
    private static final String ACCESS_KEY_ID = "LTAIedWOs9wiM17u";
    private static final String ACCESS_KEY_SECRET = "a3xVvP9ELRp6Tp6HeTzVgwcUScgmm2";
    private static final String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";
    private static final OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

    private static final Sequence sequence = new Sequence(30, 0);
    private static final String OSS_IMG_ROOT = "img/";
    private static final String OSS_IMG_COMPANY = "img/company/";

    public static String getProductImgUrl(String company, String suffix) {
        return OSS_IMG_COMPANY + company + "/" + sequence.nextId() + suffix;
    }

    public static String getSuffix(String s) {
        return s.substring(s.lastIndexOf("."));
    }

    public static boolean objectExist(String bucket, String key) {
        return ossClient.doesObjectExist(bucket, key);
    }

    public static void uploadResource(String path, InputStream inputStream) {
        ossClient.putObject(BUCKET_NAME, path, inputStream);
    }

    public static void deleteObject(String key) {
        ossClient.deleteObject(BUCKET_NAME, key);
    }

    public static void main(String[] args) throws Exception {
        uploadResource("img/product/啊啊啊/test.jpg", HTTPTool.getInputStream("http://hutool.mydoc.io/?t=255667"));
    }
}
