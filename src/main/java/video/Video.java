package video;

import video.playlist.Playlist;
import video.playlist.PlaylistProperties;
import video.sponsor.Sponsor;

public abstract class Video {
	
	private String title;
	protected int views;
	private Sponsor sponsor;
	protected Boolean premium;
	public Playlist playlist;

	public Video(String title, Sponsor sponsor) {
		super();
		this.title = title;
		this.views = 0;
		this.sponsor = sponsor;
		this.premium = false;
	}
	
	public abstract void getComments();
	
	public abstract void addViews();
	
	public abstract int getViews();
	
	public String getTitle() {
		return this.title;
	}
	
	public void addProperties(Playlist playlist) {
		this.playlist = playlist;
		playlist.addProperties(PlaylistProperties.VIDEOS, 1);
		playlist.addProperties(PlaylistProperties.VIEWS, views);
	};
	
	public void removeProperties(Playlist playlist) {
		this.playlist = null;
		playlist.removeProperties(PlaylistProperties.VIDEOS, 1);
		playlist.removeProperties(PlaylistProperties.VIEWS, views);
	};
	
	public Sponsor getSponsor() {
		return this.sponsor;
	}
	
	public Boolean premium() {
		return this.premium;
	}
	
	public String toString() {
		return "Title: "+this.title+", Views: "+this.getViews()+", Sponsor: "+this.sponsor.revenue();
	}
}
