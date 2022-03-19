package com.example.myemaildemo.Seniverse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @Author YMG
 * @Date 2021/6/24 14:55
 * @Description : 以下每个URL地址都是（心知天气的API) 只需要更换 城市 还有 购买的key就能访问到数据
 */
public class Per {
 
    public static String getWe() throws IOException {
        URL url = new URL("https://api.seniverse.com/v3/weather/daily.json?key=STSHBd7UUHPcMzKHg&location=上海&language=zh-Hans&unit=c&start=0&days=1");
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        JSONObject jsonData = JSON.parseObject(data);
        JSONArray results = jsonData.getJSONArray("results");
        JSONArray daily = results.getJSONObject(0).getJSONArray("daily");
        JSONObject jsonObject = daily.getJSONObject(0);
        Map<String, Object> dailyMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            dailyMap.put(entry.getKey(), entry.getValue());
        }
 
        return getOneS() + "\n" + "\n" + getYe()
                + "\n" + "===================="
                + "\n" + "白天天气：" + "\t" + dailyMap.get("text_day")
                + "\n" + "晚间天气：" + "\t" + dailyMap.get("text_night")
                + "\n" + "最高温度(℃)：" + "\t" + dailyMap.get("high")
                + "\n" + "最低温度(℃)：" + "\t" + dailyMap.get("low")
                + "\n" + "相对湿度(％)：" + "\t" + dailyMap.get("humidity")
                + "\n" + "当前能见度(km)：" + "\t" + getSk().get("visibility")
                + "\n" + "气压(Pa)：" + "\t" + getSk().get("pressure")
                + "\n" + "风向：" + "\t" + dailyMap.get("wind_direction")
                + "\n" + "风速(km/h)：" + "\t" + dailyMap.get("wind_speed")
                + "\n" + "风力等级：" + "\t" + dailyMap.get("wind_scale")
                + "\n" + "===================="
                + "\n" + "\n" + getSe();
    }
 
 
    public static String getSe() throws IOException {
        URL url = new URL("https://api.seniverse.com/v3/life/suggestion.json?key=STSHBd7UUHPcMzKHg&location=成都&language=zh-Hans");
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        JSONObject jsonData = JSON.parseObject(data);
        JSONArray results = jsonData.getJSONArray("results");
 
        JSONObject now = results.getJSONObject(0).getJSONObject("suggestion");
 
        Map<String, Object> suMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : now.entrySet()) {
            suMap.put(entry.getKey(), entry.getValue());
        }
        Map<String, Object> resultMap = new HashMap<>();
        for (String s : suMap.keySet()) {
            JSONObject jsonObject = JSON.parseObject(suMap.get(s).toString());
            String resultStr = jsonObject.getString("brief") + "，" + jsonObject.getString("details");
            resultMap.put(s, resultStr);
        }
 
        return "生活指数："
                + "\n" + "================================="
                + "\n" + "(空气污染)：>>>" + "\t" + resultMap.get("air_pollution")
                + "\n" + "(紫外线)：>>>" + "\t" + resultMap.get("uv")
                + "\n" + "(舒适度)：>>>" + "\t" + resultMap.get("comfort")
                + "\n" + "(雨伞)：>>>" + "\t" + resultMap.get("umbrella")
                + "\n" + "(化妆)：>>>" + "\t" + resultMap.get("makeup")
                + "\n" + "(防晒)：>>>" + "\t" + resultMap.get("sunscreen")
                + "\n" + "(过敏)：>>>" + "\t" + resultMap.get("allergy")
                + "\n" + "(风寒)：>>>" + "\t" + resultMap.get("chill")
                + "\n" + "(感冒)：>>>" + "\t" + resultMap.get("flu")
                + "\n" + "(约会)：>>>" + "\t" + resultMap.get("dating")
                + "\n" + "(运动)：>>>" + "\t" + resultMap.get("sport")
                + "\n" + "(旅游)：>>>" + "\t" + resultMap.get("travel")
                + "\n" + "(晾晒)：>>>" + "\t" + resultMap.get("airing")
                + "\n" + "=================================";
    }
 
 
    public static Map<String, Object> getSk() throws IOException {
        URL url = new URL("https://api.seniverse.com/v3/weather/now.json?key=STSHBd7UUHPcMzKHg&location=成都&language=zh-Hans&unit=c");
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        JSONObject jsonData = JSON.parseObject(data);
        JSONArray results = jsonData.getJSONArray("results");
        JSONObject now = results.getJSONObject(0).getJSONObject("now");
        Map<String, Object> skMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : now.entrySet()) {
            skMap.put(entry.getKey(), entry.getValue());
        }
        return skMap;
    }
 
    //得到农历生肖
    public static String getYe() throws IOException {
        URL url = new URL("https://api.seniverse.com/v3/life/chinese_calendar.json?key=STSHBd7UUHPcMzKHg&start=0&days=1");
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        JSONObject jsonData = JSON.parseObject(data);
        JSONObject jsonObject = jsonData.getJSONObject("results");
        JSONArray jsonArray = jsonObject.getJSONArray("chinese_calendar");
        JSONObject chinese_calendar = jsonArray.getJSONObject(0);
        Map<String, Object> chMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : chinese_calendar.entrySet()) {
            chMap.put(entry.getKey(), entry.getValue());
        }
        return chMap.get("date") + "\t" + getWeekOfDate(new Date()) + "\t" + chMap.get("ganzhi_year") + "(" + chMap.get("zodiac") + ")" + "年" + chMap.get("lunar_month_name") + chMap.get("lunar_day_name") + "\t" + chMap.get("lunar_festival")
                + "\t" + chMap.get("solar_term");
 
    }
 
    //得到情话
    public static String getOneS() throws IOException {
        //死循环，获得的情话太短直接过滤
        for (;;){
            //创建客户端对象
            HttpClient client = HttpClients.createDefault();
            /*创建地址 https://du.shadiao.app/api.php*/
            HttpGet get = new HttpGet("https://chp.shadiao.app/api.php");
            //发起请求，接收响应对象
            HttpResponse response = client.execute(get);
            //获取响应体，响应数据是一种基于HTTP协议标准字符串的对象
            //响应体和响应头，都是封装HTTP协议数据。直接使用可能出现乱码或解析错误
            HttpEntity entity = response.getEntity();
            //通过HTTP实体工具类，转换响应体数据
            String s = EntityUtils.toString(entity, "utf-8");
            if (s.length()>30){
                return s;
            }
        }
    }
 
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }
 
    public static void main(String[] args) throws IOException {
        System.out.println(getWe());
    }
 
}