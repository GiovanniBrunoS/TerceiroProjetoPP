package dataacess;

import user.NullUser;
import user.User;

public class UserDAODecorator implements UserDAOInterface {
	private static UserDAOInterface userDAO;
	
	UserDAODecorator() {};

	private UserDAOInterface getDAO() {
		if (userDAO == null)
			userDAO = new UserDAOProxy();
		return userDAO;
	}

	public User getUser(String name) {
		if(name.isEmpty())
			return new NullUser();
		
		User u = getDAO().getUser(name);
		
		if (u == null)
			return new NullUser();
		return u;
	}
}