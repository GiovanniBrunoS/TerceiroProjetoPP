package dataacess;

import java.util.ArrayList;

import user.RegisteredUser;
import user.User;

public class CDN extends UserRetriever {
	
	private ArrayList<String> users = new ArrayList<String>();

	public CDN(UserRetriever next) {
		super(next);
		users.add("João");
		users.add("Lucas");
		users.add("Marcos");
		users.add("Daiane");
	}

	@Override
	protected User retrieve(String name) {
		if (users.contains(name)) {
//			System.out.println("Recuperou user " + name + " de CDN");
			return RegisteredUser.fromName(name);			
		}
		return null;
	}

}
