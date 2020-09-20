package channel.states;

import channel.Channel;
import video.BasicVideo;
import video.Video;
import video.sponsor.NoSponsor;
import video.sponsor.Sponsor;

public class StandartChannel implements ChannelState {

	Channel channel;

	public StandartChannel(Channel channel) {
		this.channel = channel;
	}
	public void applyVerified() {
		System.out.println("Channel "+ channel.getName() + " applied for verified!");
		channel.setChannelState(channel.getVerifiedState());
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.getName() + " can't apply for sponsored yet!");
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.getName() + " got copyrighted!");
		channel.setChannelState(channel.getDemonitizedState());
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.getName() + " is already a standart channel!");
	}

	public Sponsor getSponsor() {
		return new NoSponsor();
	}
	
	public Video newVideo(String videoTitle) {
		Video newVideo = new BasicVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.getName() + " has uploaded a new video titled " + videoTitle + " , this channel is demonitized and has no revenue!");
		channel.addVideo(newVideo);
		channel.notifySubscribers(videoTitle);
		return newVideo;
	}

}
