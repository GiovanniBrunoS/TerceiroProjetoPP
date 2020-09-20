package channel.states;

import channel.Channel;
import video.PremiumVideo;
import video.Video;
import video.sponsor.BigSponsor;
import video.sponsor.Sponsor;

public class SponsoredChannel implements ChannelState {

	Channel channel;

	public SponsoredChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void applyVerified() {
		System.out.println("Channel "+ channel.getName() + " has lost it's status as sponsored and became verified!");
		channel.setChannelState(channel.getVerifiedState());
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.getName() + " is already sponsored!");
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.getName() + " got copyrighted!");
		channel.setChannelState(channel.getDemonitizedState());
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.getName() + " has lost it's status as sponsored and became a standart channel!");
		channel.setChannelState(channel.getStandartState());
	}

	public Sponsor getSponsor() {
		return new BigSponsor();
	}
	
	public Video newVideo(String videoTitle) {
		Video newVideo = new PremiumVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.getName() + " has uploaded a new video titled " + videoTitle + " , this video revenue is: " + newVideo.getSponsor().revenue());
		channel.addVideo(newVideo);
		channel.notifySubscribers(videoTitle);
		return newVideo;
	}

}
