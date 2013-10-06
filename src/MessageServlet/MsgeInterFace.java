package MessageServlet;

import java.util.HashMap;

public interface MsgeInterFace {
	public int getAllCount();
	public MessageBean getOneMessage();
	public HashMap getAllMessage();
	public int getAllCount(MsgFolder folder);

}
