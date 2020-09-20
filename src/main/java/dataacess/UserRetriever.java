package dataacess;

import user.User;

public abstract class UserRetriever {
	private UserRetriever next;

	public UserRetriever(UserRetriever next) {
		this.next = next;
	}

	public User retrieveUser(String name) {
		User a = retrieve(name);
		if (a == null)
			return callNext(name);
		else
			return a;
	}

	private User callNext(String name) {
		if (next == null)
			return null;
		return next.retrieveUser(name);
	}

	protected abstract User retrieve(String nome);
}