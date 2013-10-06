package DB;

public interface DbInterface {
	public int LogIn(UserBean userbean);
	public boolean Resiger(UserBean userbean);
	public boolean BindSid(UserBean userbean);
}
