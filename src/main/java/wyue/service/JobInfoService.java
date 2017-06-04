package wyue.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wyue.dbtool.DBtool;
import wyue.entity.JobInfo;


/**
 * Created by wangyue on 2017/1/29.
 */
public class JobInfoService extends BaseService {

    DBtool dBtool = new DBtool();

    /***
     * 操作具体网站类
     *
     * @param url      请求连接
     * @param encoding 编码集
     * @return maps
     * @author hackxhao
     * @version v1.0
     */
    public JobInfo fetchJobInfo(String url, String encoding) {
        JobInfo jobInfo = new JobInfo();
        System.out.println(url);
        // 1.根据网站和页面的编码集获取网页源代码
        String html = getHtmlResourceByUrl(url, encoding);
        // 2.解析源代码
        Document document = Jsoup.parse(html);
        jobInfo.setWeburl(url);

        Element element = document.getElementsByClass("top-fixed-box").first();
        String title = element.getElementsByTag("h1").text();
        jobInfo.setTitle(title);

        String company = element.getElementsByTag("a").text();
        jobInfo.setCompany(company);

        String labels = element.getElementsByTag("span").text().replace(" ", ",");
        jobInfo.setLabels(labels);

        element = document.getElementsByClass("terminal-ul clearfix").first();
        Elements liEls = element.getElementsByTag("strong");
        jobInfo.setSalary(liEls.get(0).text());
        jobInfo.setAddress(liEls.get(1).text());
        jobInfo.setCreate_time(liEls.get(2).text());
        jobInfo.setNature(liEls.get(3).text());
        jobInfo.setExperience(liEls.get(4).text());
        jobInfo.setEducation(liEls.get(5).text());
        jobInfo.setHiring_num(liEls.get(6).text());
        jobInfo.setPostion(liEls.get(7).text());

        element = document.getElementsByClass("tab-inner-cont").first();
        String description = element.getElementsByTag("p").text();
        jobInfo.setDescription(description);

        String detailed_address = element.getElementsByTag("h2").text();
        jobInfo.setDetailed_address(detailed_address);

        dBtool.addJob(jobInfo);

        return jobInfo;
    }

    public List<JobInfo> getJobInfos(JobInfo jobInfo){
        return dBtool.getJobInfos(jobInfo);
    }

}

