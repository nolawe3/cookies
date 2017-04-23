package servlet5;

import java.util.LinkedHashMap;
//this is it Change to Defualt2 from developer1
public class UsersDatatbase {
	private User user;
	private LinkedHashMap<String, String> userDB = new LinkedHashMap();
	
	public UsersDatatbase(){
		userDB.put("user1", "admin");
		userDB.put("user2", "admin2");
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LinkedHashMap<String, String> getUserDB() {
		return userDB;
	}
	public void setUserDB(LinkedHashMap<String, String> userDB) {
		this.userDB = userDB;
	}
}
