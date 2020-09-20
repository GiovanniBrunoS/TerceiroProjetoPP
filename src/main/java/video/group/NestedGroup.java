package video.group;

import java.util.ArrayList;

public class NestedGroup implements Group {
	
	private ArrayList<Group> groups;
	private String groupName;
	
	public NestedGroup(String groupName) {
		this.groupName = groupName;
		this.groups = new ArrayList<Group>();
	}

	public int videosAmount() {
		int videos = 0;
		if(this.groups.size() > 0) 
			for(Group group: groups) 
				videos += group.videosAmount();
		else
			System.out.println("There are no groups in the group " + groupName);
		return videos;
	}

	public void videosTitles() {
		if(this.groups.size() > 0)
			for(Group group: groups) 
				group.videosTitles();
		else
			System.out.println("There are no groups in the group " + groupName);
	}

	public int videosViews() {
		int views = 0;
		if(this.groups.size() > 0) 
			for(Group group: groups)
				views += group.videosViews();
		else
			System.out.println("There are no groups in the group " + groupName);
		return views;
	}

	public void detailedDescription() {
		if(this.groups.size() > 0) 
			for(Group group: groups) 
				group.detailedDescription();
		else
			System.out.println("There are no groups in the group " + groupName);
	}
	
	public void addGroup(Group group) {
		this.groups.add(group);
	}
	
	public String getGroupName() {
		return this.groupName;
	}

}
