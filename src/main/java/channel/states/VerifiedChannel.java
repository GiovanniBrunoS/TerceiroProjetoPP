package channel.states;

import channel.Channel;
import video.PremiumVideo;
import video.Video;
import video.sponsor.SmallSponsor;
import video.sponsor.Sponsor;

public class VerifiedChannel implements ChannelState {
	
	Channel channel;

	public VerifiedChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void applyVerified() {
		System.out.println("Channel "+ channel.getName() + " is already verified!");
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.getName() + " applied for sponsored!");
		channel.setChannelState(channel.getSponsoredState());
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.getName() + " got copyrighted!");
		channel.setChannelState(channel.getDemonitizedState());
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.getName() + " has lost it's status as verified!");
		channel.setChannelState(channel.getStandartState());
	}

	public Sponsor getSponsor() {
		return new SmallSponsor();
	}
	
	public Video newVideo(String videoTitle) {
		Video newVideo = new PremiumVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.getName() + " has uploaded a new video titled " + videoTitle + " , this video revenue is: " + newVideo.getSponsor().revenue());
		channel.addVideo(newVideo);
		channel.notifySubscribers(videoTitle);
		return newVideo;
	}

}
