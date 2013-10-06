package GradeManage;

public class GradeBean {
	/*
	 * 	midgrade int(4) NULL
		peacetime int(4) NULL
		practic int(4) NULL
		finnal int(4) NULL
		all int(4) NULL
		name string
	*/
	private String sid;
	private String sname;
	private String sclass;
	private int midgrade;
	private int peacetime ;
	private int practic;
	private int finnal;
	private long all;
	
	public int getMidgrade() {
		return midgrade;
	}
	public void setMidgrade(int midgrade) {
		this.midgrade = midgrade;
	}
	public int getPractic() {
		return practic;
	}
	public void setPractic(int practic) {
		this.practic = practic;
	}

	public int getPeacetime() {
		return peacetime;
	}

	public void setPeacetime(int peacetime) {
		this.peacetime = peacetime;
	}

	public int getFinnal() {
		return finnal;
	}

	public void setFinnal(int finnal) {
		this.finnal = finnal;
	}

	public long getAll() {
		return all;
	}

	public void setAll(long all) {
		this.all = all;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	
}
