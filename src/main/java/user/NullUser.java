package user;

import channel.Channel;
import video.Video;

public class NullUser extends User {
	
	public NullUser() {
		super("Guest", false);
	}

	@Override
	public void update(String update) {}

	@Override
	public void watch(Channel channel) {
		for(Video video : channel.getVideos()) {
			if(video.premium())
				System.out.println("User " + getName() + " has to register to watch this video!");
			else {
				System.out.println("User " + getName() + " watched " + video.getTitle());
				video.addViews();
			}
		}
	}

}
