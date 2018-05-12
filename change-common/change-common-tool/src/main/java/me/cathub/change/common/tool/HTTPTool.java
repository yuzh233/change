package me.cathub.change.common.tool;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;

public class HTTPTool {
    private static OkHttpClient client = new OkHttpClient();

    public static String $(String url) {
        String suffix = url.substring(url.lastIndexOf("."));
        String temp_1 = url.substring(0, url.lastIndexOf("."));
        return temp_1.substring(0, temp_1.lastIndexOf(".")) + suffix;
    }

    public static InputStream getInputStream(String url) {
        url = $(url);
        if (! url.contains("http"))
            url = "http:" + url;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            if (response == null || ! response.isSuccessful())
                return null;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return response.body().byteStream();
    }

    public static void main(String[] args) {
        System.out.println($("//cbu01.alicdn.com/img/ibank/2018/360/223/8562322063_151588481.220x220.jpg"));
    }
}
