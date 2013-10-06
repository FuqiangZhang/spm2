package MessageServlet;

import java.util.Vector;

public class MsgFolder {
	private String title;
	private Vector<MessageBean>  messages;
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	/**
	 * 该项下添加一个message
	 * @param msg
	 * @return
	 */
	public boolean addMsg(MessageBean msg){
		boolean flag = false;
		messages.add(msg);
		return flag;
	}
	/**
	 * 该项下删除一个message
	 * @param msg
	 * @return
	 */
	public boolean removeMsg(MessageBean msg){
		for(int i=0;i<messages.size();i++){
			if((msg.getTitle()).equals((messages.get(i)).getTitle())){
				messages.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 检查是否有重复标题的message
	 * @param msg
	 * @return
	 */
	public boolean checkRepeat(MessageBean msg){
		boolean flag = false;
		for(int i=0;i<messages.size();i++){
			if((msg.getTitle()).equals((messages.get(i)).getTitle())){
				flag = true;
				
			}
		}
		return flag;
	}
	
	
}
