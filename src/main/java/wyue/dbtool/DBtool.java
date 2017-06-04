package wyue.dbtool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wyue.entity.JobInfo;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangyue on 2017/1/30.
 */
public class DBtool {

    private String resource = "mybatis.xml";
    private SqlSessionFactory sessionFactory = null;
    private Reader reader = null;

    public DBtool(){
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public void addJob(JobInfo jobInfo) {
        SqlSession session = sessionFactory.openSession();
        String statement = "mybatis.addJobInfo";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        session.insert(statement,jobInfo);
        session.commit();
        session.close();
    }

    public List<JobInfo> getJobInfos(JobInfo jobInfo){
        SqlSession session = sessionFactory.openSession();
        String statement = "mybatis.getJobInfos";
        List<JobInfo> jobInfos = session.selectList(statement,jobInfo);
        session.close();
        return jobInfos;
    }


}
