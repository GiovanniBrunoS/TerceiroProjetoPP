package channel;

import java.util.ArrayList;

import channel.states.ChannelState;
import channel.states.DemonitizedChannel;
import channel.states.SponsoredChannel;
import channel.states.StandartChannel;
import channel.states.VerifiedChannel;
import user.User;
import video.Video;
import video.group.Group;
import video.group.NestedGroup;
import video.group.VideoGroup;

public class Channel {
	
	private User owner;
	private String name;
	private ArrayList<Video> videos;
	private ArrayList<User> subscribers;
	private NestedGroup mainGroup;
	
	private ChannelState channelState;
		
	private int copyrightCounter;

	public Channel() {
		super();
		this.videos = new ArrayList<Video>();
		this.subscribers = new ArrayList<User>();
		this.copyrightCounter = 0;
		this.mainGroup = new NestedGroup("main");
		channelState = new StandartChannel(this);
	}
	
	public Channel ownedBy(User owner) {
		this.owner = owner;
		return this;
	}
	
	public Channel named(String name) {
		this.name = name;
		return this;
	}

	public void addSubscribers(User subscriber) {
		if(subscriber.getRegisterStatus()) {
			System.out.println("User " + subscriber.getName() + " has subscribed to channel " + name);
			this.subscribers.add(subscriber);
		}
		else
			System.out.println("User "+ subscriber.getName()  +" isn't registered");
	}
	
	public void removeSubscribers(User subscriber) {
		System.out.println("User " + subscriber.getName() + " has unsubscribed from channel " + name);
		this.subscribers.remove(subscriber);
	}
	
	public void notifySubscribers(String title) {
		for(User subscriber: subscribers) {
			subscriber.update("New video " + title + " in channel " + name);
		}
	}
	
	public User getOwner() {
		return owner;
	}
	
	public String getName() {
		return name;
	}

	public int getCopyrightCounter() {
		return copyrightCounter;
	}

	public void increaseCopyrightCounter() {
		this.copyrightCounter += 1;
	}
	
	public void resetCopyrightCounter() {
		this.copyrightCounter = 0;
	}
	
	public Video newVideo(String videoTitle) {
		return channelState.newVideo(videoTitle);
	}
	
	public void addVideo(Video newVideo) {
		videos.add(newVideo);
	}
	
	public ArrayList<Video> getVideos(){
		return videos;
	}
	
	public void addGroup(VideoGroup videoGroup) {
		mainGroup.addGroup(videoGroup);
	}
	
	public Group getGroup() {
		return this.mainGroup;
	}
	
	public void setChannelState(ChannelState newChannelState) {
		channelState = newChannelState;
	}
	
	public void applyVerified() {
		channelState.applyVerified();
	}
	
	public void applySponsored() {
		channelState.applySponsored();
	}
	
	public void getCopyright() {
		increaseCopyrightCounter();
		channelState.getCopyright();
	}
	
	public void applyStandart() {
		channelState.applyStandart();
	}
	
	public ChannelState getVerifiedState() {
		System.out.println("Channel "+ name + " is now Verified!");
		return new VerifiedChannel(this);
	}
	
	public ChannelState getSponsoredState() {
		System.out.println("Channel "+ name + " is now Sponsored!");
		return new SponsoredChannel(this);
	}
	
	public ChannelState getDemonitizedState() {
		System.out.println("Channel "+ name + " is now Demonitized!");
		return new DemonitizedChannel(this);
	}
	
	public ChannelState getStandartState() {
		System.out.println("Channel "+ name + " is now a Standart Channel!");
		return new StandartChannel(this);
	}
}
