package MessageServlet;

public class MessageBean {
	private String id;
	private String title;
	private String context;
	private String pic_url;
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	
	public void setContext(String context){
		this.context = context;
	}
	public String getContext(){
		return this.context;
	}
	
	public void setPic(String pic_url){
		this.pic_url = pic_url;
	}
	public String getPic(){
		return this.pic_url;
	}
}
