package wyue.entity;


/**
 * Created by wangyue on 2017/1/31.
 */
public class JobInfo {
    private  int job_id; //	job_id	int
    private  String weburl; //	weburl	varchar
    private  String title; //	title	varchar
    private  String company; //公司名	company	varchar	公司名
    private  String labels; //标签	labels	varchar	标签
    private  String salary; //月薪	salary	varchar	月薪
    private  String address; //	address	varchar
    private  String create_time; //	create_time	timestamp
    private  String experience; //工作经验	experience	varchar	工作经验
    private  String nature; //工作性质	nature	varchar	工作性质
    private  String education; //学历	education	varchar	学历
    private  String hiring_num; //招聘人数	hiring_num	varchar	招聘人数
    private  String postion; //职位类别	postion	varchar	职位类别
    private  String description; //职位描述	description	text	职位描述
    private  String detailed_address; //详细地址	detailed_address	varchar	详细地址


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailed_address() {
        return detailed_address;
    }

    public void setDetailed_address(String detailed_address) {
        this.detailed_address = detailed_address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getHiring_num() {
        return hiring_num;
    }

    public void setHiring_num(String hiring_num) {
        this.hiring_num = hiring_num;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }
}
