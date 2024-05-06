package org.example.backend.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

public class MyUtils {
    //处理一些公共的问题，比如时间转换，cookie信息读取等等
    //String cookieValue = "userID = "+ userID + "; tableID = " + tableID;这是我生成cookie的格式
    //读取cookie信息

    public static String[] getCookieInfo(String cookie) {
        //cookie的形式是 "userID = "+ userID + "; tableID = " + tableID，我需要读出userID和tableID
        String[] keyValuePairs = cookie.split(";");
        String[] cookieInfo = new String[2]; // 0: userID, 1: tableID

        // 默认值
        cookieInfo[0] = "";
        cookieInfo[1] = "-1";

        for (String pair : keyValuePairs) {
            // 再次分割键值对成键和值
            String[] keyValue = pair.trim().split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                // 找到键为 "userID" 的值
                if (key.equalsIgnoreCase("userID")) {
                    cookieInfo[0] = value;
                }
                // 找到键为 "tableID" 的值
                else if (key.equalsIgnoreCase("tableID")) {
                    cookieInfo[1] = value;
                }
            }
        }
        //注意，这里返回的是两个字符串，要将tableID转换成数字才行
        return cookieInfo;
    }

    public static String setCookie(String userID, Integer tableID) {
        String cookieValue = "userID="+ userID + ";tableID=" + tableID;
        return cookieValue;
    }

    public static Date stringToDate(String date) {
        //将字符串转换成日期
        if(date == null)
            return null;
        else {
            return Date.valueOf(date);
        }
    }
}
