package video.playlist;

import video.Video;

public class RemoveVideoFromPlaylist implements Commands{
	
	private Playlist playlist;
	private Video video;

	public RemoveVideoFromPlaylist(Playlist playlist, Video video) {
		super();
		this.playlist = playlist;
		this.video = video;
	}
	
	public void doAction() {
		playlist.removeVideo(video);
	}

	public void undoAction() {
		playlist.addVideo(video);
	}

}
