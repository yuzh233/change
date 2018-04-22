package me.cathub.change.db.collection.tool;

import me.cathub.change.db.collection.Constant;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class HTTPTools {
    private static final OkHttpClient client = new OkHttpClient();

    public static String getHtml(String url, Map<String, String> headMap) throws Exception {
        Request.Builder builder = new Request.Builder()
                .url(url);

        if (headMap != null) {
            Set<Map.Entry<String, String>> heads = headMap.entrySet();
            for (Map.Entry<String, String> head : heads) {
                String key = head.getKey();
                String value = head.getValue();
                builder.addHeader(key, value);
            }
        } else {
            builder.addHeader("cookie", Constant.DEFAULT_ALIBABA_COOKIE);
            builder.addHeader("referer", Constant.DEFAULT_REFERER);
            builder.addHeader("user-agent", Constant.DEFAULT_USER_AGENT);
        }

        Request request = builder.build();

        String content = null;
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new Exception("request return of code error:" + response.code());

            content = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getHtml(String url) throws Exception {
        return getHtml(url, null);
    }


    /**
     * URL编码
     * @param url
     * @return
     */
    public static String urlEncode(String url) {
        try {
            return URLEncoder.encode(url, "GBK");
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" + e.getMessage();
        }
    }

    /**
     * URL 解码
     * @param url
     * @return
     */
    public static String urlDecode(String url) {
        try {
            String prevURL = "";
            String decodeURL = url;
            while (!prevURL.equals(decodeURL)) {
                prevURL = decodeURL;
                decodeURL = URLDecoder.decode(decodeURL, "GBK");
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" + e.getMessage();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(getHtml("https://s.1688.com/company/company_search.htm?keywords=%B1%A3%CE%C2%B1%AD&n=y&mastheadtype=&from=industrySearch&industryFlag=home"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
