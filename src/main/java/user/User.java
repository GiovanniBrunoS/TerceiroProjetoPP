package user;

import channel.Channel;

public abstract class User {
	
	private String name;
	private Boolean registered;
	
	protected User(String name, Boolean registered) {
		this.name = name;
		this.registered = registered;
	}
	
	public Boolean getRegisterStatus() {
		return registered;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void update(String update);
	
	public abstract void watch(Channel channel);
		
}
