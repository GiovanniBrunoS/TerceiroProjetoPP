package video;

import java.util.ArrayList;

import video.playlist.Playlist;
import video.playlist.PlaylistProperties;
import video.sponsor.Sponsor;

public class PremiumVideo extends BasicVideo{
	
	public int likes;
	public ArrayList<Comment> comments;

	public PremiumVideo(String title, Sponsor sponsor) {
		super(title, sponsor);
		this.likes = 0;
		this.comments = new ArrayList<Comment>();
		this.premium = true;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void getComments() {
		for(Comment comments : comments)
			System.out.println("Video: "+ this.getTitle() +" User:" + comments.getOwner() + " Commented: " + comments.getText());
	}
	
	public void addProperties(Playlist playlist) {
		super.addProperties(playlist);
		playlist.addProperties(PlaylistProperties.LIKES, likes);
	};
	
	public void removeProperties(Playlist playlist) {
		super.removeProperties(playlist);
		playlist.removeProperties(PlaylistProperties.LIKES, likes);
	};
}
