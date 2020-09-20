package video.group;

import java.util.ArrayList;

import video.Video;

public class VideoGroup implements Group {
	
	private ArrayList<Video> videos;
	private String groupName;
	
	public VideoGroup(String groupName) {
		this.groupName = groupName;
		this.videos = new ArrayList<Video>();
	}

	public int videosAmount() {
		if(this.videos.size() > 0)
			System.out.println(groupName + ": " + this.videos.size() + " videos");
		else
			System.out.println("There are no videos in the group " + groupName);
		return this.videos.size();
	}

	public void videosTitles() {
		if(this.videos.size() > 0)
			for(Video video:videos) 
				System.out.println(groupName + ": " + video.getTitle());
		else
			System.out.println("There are no videos in the group " + groupName);
	}

	public int videosViews() {
		int views = 0;
		if(this.videos.size() > 0) {
			for(Video video:videos) 
				views =+ video.getViews();
			System.out.println(groupName + ": " + views + " views");
		}
		else
			System.out.println("There are no videos in the group " + groupName);
		return views;
	}

	public void detailedDescription() {
		if(this.videos.size() > 0) 
			for(Video video:videos) 
				System.out.println("Group: " + groupName + ", " + video.toString());
		else
			System.out.println("There are no videos in the group " + groupName);
	}
	
	public void addVideo(Video video) {
		this.videos.add(video);
	}

	public String getGroupName() {
		return this.groupName;
	}
}
