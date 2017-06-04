package wyue.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wyue.dbtool.DBtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Created by wangyue on 2017/1/29.
 */
public class FetchBookService extends BaseService{

    /***
     * 抓取成人小说
     *
     * @param url      请求连接
     * @param encoding 编码集
     * @return maps
     * @author hackxhao
     * @version v1.0
     */
    public HashMap<String, String> getBookInfo(String url, String encoding) {
        System.out.println(url);
        // 1.根据网站和页面的编码集获取网页源代码
        String html = getHtmlResourceByUrl(url, encoding);
        // 2.解析源代码
        Document document = Jsoup.parse(html);
        // 创建一个List集合
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("weburl",url);

        Element element = document.getElementsByClass("top-fixed-box").first();
        String title = element.getElementsByTag("h1").text();
        map.put("title", title);

        String company = element.getElementsByTag("a").text();
        map.put("company", company);

        String labels = element.getElementsByTag("span").text().replace(" ",",");
        map.put("labels",labels);

        element = document.getElementsByClass("terminal-ul clearfix").first();
        Elements liEls = element.getElementsByTag("strong");
        map.put("salary",liEls.get(0).text());
        map.put("address",liEls.get(1).text());
        map.put("create_time",liEls.get(2).text());
        map.put("nature",liEls.get(3).text());
        map.put("experience",liEls.get(4).text());
        map.put("education",liEls.get(5).text());
        map.put("hiring_num",liEls.get(6).text());
        map.put("postion",liEls.get(7).text());

        element = document.getElementsByClass("tab-inner-cont").first();
        String description = element.getElementsByTag("p").text();
        map.put("description",description);

        String detailed_address = element.getElementsByTag("h2").text();
        map.put("detailed_address",detailed_address);
        System.out.println(map);

        return map;
    }




}

