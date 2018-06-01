package me.cathub.change.common.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 将jar文件copy到指定目录下
 */
public class Publish {
    static String rpcPath = "C:\\Users\\cheng\\Desktop\\[ CHANGE ]\\[ Publish ]\\rpcServer";
    static String webPath = "C:\\Users\\cheng\\Desktop\\[ CHANGE ]\\[ Publish ]\\webServer";

    public static void main(String[] args) throws Exception {
        packageRpcServer();
    }

    public static void packageRpcServer() throws Exception {
        Map<String, String> jars = new HashMap<>(5);
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\out\\artifacts\\change_user_rpc_server_war\\change-user-rpc-server_war.war", "A.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\out\\artifacts\\change_upms_rpc_server_war\\change-upms-rpc-server_war.war", "B.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\out\\artifacts\\change_product_rpc_server_war\\change-product-rpc-server_war.war", "C.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\out\\artifacts\\change_storehouse_rpc_server_war\\change-storehouse-rpc-server_war.war", "D.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\out\\artifacts\\change_order_rpc_server_war\\change-order-rpc-server_war.war", "E.war");

        Set<Map.Entry<String, String>> entries = jars.entrySet();
        for (Map.Entry<String, String> entrie:entries) {
            String key = entrie.getKey();
            String value = entrie.getValue();

            File file = new File(key);
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(rpcPath, value)));

            int len;
            while ((len = input.read()) != -1) {
                output.write(len);
            }

            output.close();
            input.close();
        }
    }

    public static void packageWebApply() throws Exception {
        Map<String, String> jars = new HashMap<>(5);
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\change-admin\\change-admin-order\\target\\change-admin-order-1.0-SNAPSHOT.war", "change-order\\ROOT.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\change-admin\\change-admin-storehouse\\target\\change-admin-storehouse-1.0-SNAPSHOT.war", "change-storehouse\\ROOT.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\change-admin\\change-admin-product\\target\\change-admin-product-1.0-SNAPSHOT.war", "change-product\\ROOT.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\change-admin\\change-admin-upms\\target\\change-admin-upms-1.0-SNAPSHOT.war", "change-upms\\ROOT.war");
        jars.put("C:\\Users\\cheng\\Desktop\\git\\change\\change-admin\\change-admin-user\\target\\change-admin-user-1.0-SNAPSHOT.war", "change-user\\ROOT.war");

        File dir = new File(webPath);
        for (Map.Entry<String, String> entry:jars.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            String tempStr = value.substring(0, value.indexOf("\\"));
            File tempFile = new File(webPath, tempStr);
            if (! tempFile.exists()) {
                tempFile.mkdirs();
            }

            File resource = new File(key);
            File file = new File(dir, value);
            if (! file.exists()) {
                file.createNewFile();
            }

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(resource));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            int len;
            while ((len = input.read()) != -1) {
                output.write(len);
            }
            output.close();
            input.close();
        }
    }
}