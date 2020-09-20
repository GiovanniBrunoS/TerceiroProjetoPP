package user;

import java.util.Random;

import channel.Channel;
import video.Comment;
import video.PremiumVideo;
import video.Video;

public class RegisteredUser extends User{
	
	private String displayName;
	private String gender;
	private static RegisteredUser registeredUser;
	
	private RegisteredUser(String name, String displayName, String gender) {
		super(name, true);
		this.displayName = displayName;
		this.gender = gender;
	}
	
	private RegisteredUser(String name, String displayName) {
		super(name, true);
		this.displayName = displayName;
		this.gender = "";
	}
	
	private RegisteredUser(String name) {
		super(name, true);
		this.displayName = name;
		this.gender = "";
	}
	
	public static User fromName(String name) {
		if (registeredUser == null) {
			return new RegisteredUser(name);
		}
		registeredUser.setName(name);
		return registeredUser;
	}
	
	public static User fromNameDisplay(String name, String displayName) {
		if (registeredUser == null) {
			return new RegisteredUser(name, displayName);
		}
		registeredUser.setName(name);
		registeredUser.setDisplayName(displayName);
		return registeredUser;
	}
	
	public static User fromNameGender(String name, String gender) {
		if (registeredUser == null) {
			RegisteredUser u = new RegisteredUser(name);
			u.setGender(gender);
			return u;
		}
		registeredUser.setName(name);
		registeredUser.setGender(gender);
		return registeredUser;
	}
	
	public static User fromNameDisplayGender(String name, String displayName, String gender) {
		if (registeredUser == null) {
			return new RegisteredUser(name, displayName, gender);
		}
		registeredUser.setName(name);
		registeredUser.setDisplayName(displayName);
		registeredUser.setGender(gender);
		return registeredUser;
	}
		
	public void update(String update) {
		System.out.println(getName() + " has been notified of " + update);
	}

	@Override
	public void watch(Channel channel) {
		for(Video video : channel.getVideos()) {
			System.out.println("User " + getName() + " watched " + video.getTitle());
			video.addViews();
			if(video.premium())
				commentVideo((PremiumVideo) video);
		}
	}
	
	public void commentVideo(PremiumVideo video) {
		Random r = new Random();
		video.addComment(new Comment(this, CommentFactory.get(r.nextInt((4 - 0)))));
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return "Name: " + this.getName() +", Display name: "+ this.getDisplayName() + ", Gender: " + this.getGender();
	}
}
