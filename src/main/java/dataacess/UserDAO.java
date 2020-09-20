package dataacess;

import user.User;

public class UserDAO {
	private static UserDAOInterface decorator;
	
	private UserDAO() {}
	
	public static User getUser(String name) {
		if(decorator == null) {
			decorator = new UserDAODecorator();
		}
		return decorator.getUser(name);		
	}
}
