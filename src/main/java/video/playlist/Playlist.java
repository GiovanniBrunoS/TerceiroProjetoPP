package video.playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import video.Video;

public class Playlist {
	
	private List<Video> videos;
	private Map<PlaylistProperties, Double> properties;

	protected void addVideo(Video vid) {
		getVideos().add(vid);
		vid.addProperties(this);
	}
	
	protected void removeVideo(Video vid) {
		getVideos().remove(vid);
		vid.removeProperties(this);
	}

	public void addProperties(PlaylistProperties tipo, double valor) {
		getProperties().put(tipo, getProperties().get(tipo) + valor);
	}
	
	public void removeProperties(PlaylistProperties tipo, double valor) {
		getProperties().put(tipo, getProperties().get(tipo) - valor);
	}
	
	protected String getTotal() {
		return "Videos: " + getProperties().get(PlaylistProperties.VIDEOS);
	}

	protected String getViews() {
		return "Views: " + getProperties().get(PlaylistProperties.VIEWS);
	}

	protected String getLikes() {
		return "Likes: " + getProperties().get(PlaylistProperties.LIKES);
	}

	protected List<Video> getVideos() {
		if (videos == null)
			videos = new ArrayList<Video>();
		return videos;
	}

	protected Map<PlaylistProperties, Double> getProperties() {
		if (properties == null) {
			properties = new HashMap<PlaylistProperties, Double>();
			for (PlaylistProperties tipo : PlaylistProperties.values())
				properties.put(tipo, 0.0);
		}
		return properties;
	}
}
