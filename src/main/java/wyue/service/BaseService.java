package wyue.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

/**
 * Created by wangyue on 2017/1/31.
 */
public class BaseService {



    /**
     * 解析首页a链接里面的内容
     *
     * @author hackxhao
     * @version v1.0
     */
    public LinkedList<String> getLinkInfos(String url, String encoding) {
        LinkedList<String> hrefList = new LinkedList<String>();

        int p = 1;
        while (true) {
            // 1.根据网站和页面的编码集获取网页源代码
            String html = getHtmlResourceByUrl(url + "&p=" + p, encoding);
            // 2.解析源代码
            Document document = Jsoup.parse(html);
            // 3.读取a链接列表
            Elements elements = document.select("td.zwmc > div");
            if (elements.size() == 0) {
                break;
            }
//            System.out.println("============page=" + p + "===============");
            for (Element el : elements) {
                // 获取a连接
                String href = el.getElementsByTag("a").attr("href");
//                System.out.println(href);
                hrefList.add(href);
            }
            p++;
        }


        return hrefList;
    }


    /**
     * 读取网站源码信息工具类
     *
     * @param url      请求连接
     * @param encoding 编码集
     * @return buffer
     * @author hackxhao
     * @version v1.0
     */
    public String getHtmlResourceByUrl(String url, String encoding) {
        // 存储源代码容器
        StringBuffer buffer = new StringBuffer();
        URL urlObj = null;
        URLConnection uc = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;

        try {
            // 建立网络连接
            urlObj = new URL(url);
            // 打开网络连接
            uc = urlObj.openConnection();
            // 建立文件写入流
            isr = new InputStreamReader(uc.getInputStream(), encoding);
            // 建立缓存流写入流
            reader = new BufferedReader(isr);
            // 建立临时文件
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                buffer.append(temp + "\n"); // 追加内容（一边读一边写）
            }

        } catch (MalformedURLException e) {

            e.printStackTrace();
            System.out.println("没有联网,检查设置");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("打开网络连接失败，请稍后重试");
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


        return buffer.toString();
    }

}
