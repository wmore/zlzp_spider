package wyue;

import wyue.entity.JobInfo;
import wyue.service.JobInfoService;


/**
 * Created by wangyue on 2017/1/30.
 */
public class Run {

    public static final String MAIN_URL = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E7%A6%8F%E5%B7%9E&kw=java&sm=0";
    public static final String ENCODING = "UTF-8";

    /**
     * java 入口
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(JobInfoService.getHtmlResourceByUrl(MAIN_URL, ENCODING));
 /*       JobInfoService fetchService = new JobInfoService();
        LinkedList<String> hrefs = fetchService.getLinkInfos(MAIN_URL,ENCODING);
        for(String href: hrefs){
            if(!href.contains("xiaoyuan"))
                fetchService.getJobInfo(href,ENCODING);
        }*/
        JobInfoService jobInfoService = new JobInfoService();
        System.out.println(jobInfoService.getJobInfos(new JobInfo()));
//        fetchService.getJobInfo("http://jobs.zhaopin.com/476472628270429.htm",ENCODING);
    }

 /*抓取福利社 成人小说
    public static void main(String[] args) {
        FetchBookService fetchBookService  = new FetchBookService();
        fetchBookService.getLinkInfos("http://www.fulishee.com/category/xiaoyuan/page/",ENCODING);

    }*/
}
