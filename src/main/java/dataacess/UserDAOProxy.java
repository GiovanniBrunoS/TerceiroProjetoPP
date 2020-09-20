package dataacess;

import user.User;

public class UserDAOProxy implements UserDAOInterface {
	
	private UserRetriever retriever;

	UserDAOProxy() {
		super();
		this.retriever = new CDN(new SQLDatabase(null));
	}

	public User getUser(String name) {
		return retriever.retrieveUser(name);
	}
}