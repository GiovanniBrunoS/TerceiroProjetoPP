package dataacess;

import java.util.ArrayList;

import user.RegisteredUser;
import user.User;

public class SQLDatabase extends UserRetriever {
	
	private ArrayList<String> users = new ArrayList<String>();

	public SQLDatabase(UserRetriever next) {
		super(next);
		users.add("Marcia");
	}

	@Override
	protected User retrieve(String name) {
		if (users.contains(name)) {
//			System.out.println("Recuperou user " + name + " de SQL");
			return RegisteredUser.fromName(name);			
		}
		return null;
	}

}
