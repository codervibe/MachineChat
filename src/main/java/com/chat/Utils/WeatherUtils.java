package com.chat.Utils;
/*
 * Created by Administrator on 2020/7/22  0022
 * DateTime:2020/07/22 19:51
 * Description:
 * Others:
 */

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zyj jayzh1993@gmail.com
 * @ClassName WeatherUtils
 * @Description TODO 天气信息数据来源(http://www.webxml.com.cn/)
 * 根据城市或地区名称查询获得未来三天内天气情况、现在的天气实况、天气和生活指数:
 * 调用方法如下：输入参数：theCityName = 城市中文名称(国外城市可用英文)或城市<span class="wp_keywordlink" style="margin: 0px; padding: 0px; border: 0px; background-color: transparent;"><a target=_blank href="http://www.xuebuyuan.com/" title="代码" target="_blank" style="text-decoration: none; color: rgb(1, 150, 227);">代码</a></span>(不输入默认为上海市)，如：上海 或 58367，如有
 * 城市名称重复请使用城市代码查询(可通过 getSupportCity 或 getSupportDataSet 获得)；返回数据： 一个一维数组 String(22)，共有
 * 23个元素。String(0) 到 String(4)：省份，城市，城市代码，城市图片名称，最后更新时间。String(5) 到 String(11)：当天的 气温，
 * 概况，风向和风力，天气趋势开始图片名称(以下称：图标一)，天气趋势结束图片名称(以下称：图标二)，现在的天气实况，天气和生活
 * 指数。String(12) 到String(16)：第二天的 气温，概况，风向和风力，图标一，图标二。String(17) 到 String(21)：第三天的 气温，
 * 概况，风向和风力，图标一，图标二。String(22) 被查询的城市或地区的介绍
 * @date 2013-10-14
 */
public class WeatherUtils {

    /**
     * 获取SOAP的请求头，并替换其中的标志符号为用户输入的城市
     *
     * @param city 用户输入的城市名称
     * @return 客户将要发送给服务器的SOAP请求
     */
    private static String getSoapRequest(String city) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soap:Body>    <getWeather xmlns=\"http://WebXml.com.cn/\">"
                + "<theCityCode>" + city
                + "</theCityCode>    </getWeather>"
                + "</soap:Body></soap:Envelope>");
        return sb.toString();
    }

    /**
     * 用户把SOAP请求发送给服务器端，并返回服务器点返回的输入流
     *
     * @param city 用户输入的城市名称
     * @return 服务器端返回的输入流，供客户端读取
     * @throws Exception
     */
    private static InputStream getSoapInputStream(String city) throws Exception {
        try {
            String soap = getSoapRequest(city);
            if (soap == null) {
                return null;
            }
            URL url = new URL(
                    "http://www.webxml.com.cn/WebServices/WeatherWS.asmx");
            URLConnection conn = url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", Integer.toString(soap
                    .length()));
            conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            conn.setRequestProperty("SOAPAction",
                    "http://WebXml.com.cn/getWeather");

            OutputStream os = conn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            osw.write(soap);
            osw.flush();
            osw.close();

            InputStream is = conn.getInputStream();
            return is;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对服务器端返回的XML进行解析
     *
     * @param city 用户输入的城市名称
     * @return 字符串 用#分割
     */
    public static String getWeather(String city) {
        try {
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream is = getSoapInputStream(city);
            doc = db.parse(is);
            NodeList nl = doc.getElementsByTagName("string");
            StringBuffer sb = new StringBuffer();
            for (int count = 0; count < nl.getLength(); count++) {
                Node n = nl.item(count);
                if (n.getFirstChild().getNodeValue().equals("查询结果为空！")) {
                    sb = new StringBuffer("#");
                    break;
                }
                sb.append(n.getFirstChild().getNodeValue() + "\n");
            }
            is.close();
            String weather = sb.toString();
            weather = weather.replace("1.gif", "");
            weather = weather.replace("2.gif", "");
            weather = weather.replace("3.gif", "");
            weather = weather.replace("4.gif", "");
            weather = weather.replace("5.gif", "");
            weather = weather.replace("6.gif", "");
            weather = weather.replace("7.gif", "");
            weather = weather.replace("8.gif", "");
            weather = weather.replace("9.gif", "");
            weather = weather.replace("0.gif", "");
            return weather;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    /**
//     * 测试
//     *
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception {
//        String weatherInfo = getWeather("武汉");
//        System.out.println(weatherInfo);
//    }
}


