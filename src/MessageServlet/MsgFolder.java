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
	 * ���������һ��message
	 * @param msg
	 * @return
	 */
	public boolean addMsg(MessageBean msg){
		boolean flag = false;
		messages.add(msg);
		return flag;
	}
	/**
	 * ������ɾ��һ��message
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
	 * ����Ƿ����ظ������message
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
