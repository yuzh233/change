package me.cathub.change.apply.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: z.yu
 * @Date: 2018/05/25 17:11
 */
public class ListUtils {

    /**
     * 拆分集合，三个一组。比如：
     *  str[0]:123/456/789
     *  str[1]:789/456/123
     *  str[2]:456/789/123
     */
    public static List<String> splitList(List targetList) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < targetList.size(); i++) {
            if ((i + 1) % 3 == 0) {
                String s1 = (String) targetList.get(i - 2);
                String s2 = (String) targetList.get(i - 1);
                String s3 = (String) targetList.get(i);
                //每三组创建一个字符串
                String str = s1 + " / " + s2 + " / " + s3;
                stringList.add(str);
            }
        }
        //余数,只有1和2两种可能。
        int rem = targetList.size() % 3;
        String str2 = "";
        for (int j = targetList.size() - rem; j < targetList.size(); j++) {
            str2 += targetList.get(j) + " / ";
        }
        str2 = str2.substring(0, str2.length()-2);
        stringList.add(str2);
        return stringList;
    }

}
