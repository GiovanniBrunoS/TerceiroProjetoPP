package video;

import user.RegisteredUser;

public class Comment {
	
	public RegisteredUser owner;
	public String text;
	
	public Comment(RegisteredUser owner, String text) {
		super();
		this.owner = owner;
		this.text = text;
	}

	public String getOwner() {
		return owner.getName();
	}

	public String getText() {
		return text;
	}

}
