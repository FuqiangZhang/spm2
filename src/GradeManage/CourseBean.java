package GradeManage;

public class CourseBean {
	
	private String username;
	private String pwd;
	private boolean admin;//�Ƿ�Ϊ����Ա
	private String duty;//ְ����ʦ,ѧ��,���֣�
	private String sid;//ѧ��
	private String sname;//����
	private String sclass;
	private boolean state;
	
	public void setState(boolean state){
		this.state = state;
	}
	public boolean getState(){
		return this.state;
	}
	public void setSclass(String sclass){
		this.sclass = sclass;
	}
	public String getSclass(){
		return this.sclass;
	}
	public void setSid(String sid){
		this.sid = sid;
	}
	public String getSid(){
		return this.sid;
	}
	
	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(){
		return this.sname;
	}
	public void setDuty(String duty){
		this.duty = duty;
	}
	public String getDuty(){
		return this.duty;
	}
	
	public void setName(String username){
		this.username = username;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public String getName(){
		return this.username;
	}
	public String getPwd(){
		return this.pwd;
	}
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	public boolean getAdmin(){
		return this.admin;
	}
}
