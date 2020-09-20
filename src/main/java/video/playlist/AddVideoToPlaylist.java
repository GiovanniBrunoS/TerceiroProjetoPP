package video.playlist;

import video.Video;

public class AddVideoToPlaylist implements Commands{
	
	private Playlist playlist;
	private Video video;

	public AddVideoToPlaylist(Playlist playlist, Video video) {
		super();
		this.playlist = playlist;
		this.video = video;
	}
	
	public void doAction() {
		playlist.addVideo(video);
	}

	public void undoAction() {
		playlist.removeVideo(video);
	}

	

}
