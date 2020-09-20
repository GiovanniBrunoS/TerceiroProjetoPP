package channel.states;

import video.Video;

public interface ChannelState {

	void applyVerified();
	void applySponsored();
	void getCopyright();
	void applyStandart();
	Video newVideo(String videoTitle);
	
}
