package video.playlist;

import video.Video;

public class PlaylistManager {
	
	private Playlist playlist;
	private CommandExecuter exec;
	
	public PlaylistManager() {
		super();
		this.playlist = new Playlist();
		this.exec = new CommandExecuter();
	}
	
	public void addVideo(Video vid) {
		exec.execute(new AddVideoToPlaylist(playlist, vid));
	}
	
	public void removeVideo(Video vid) {
		exec.execute(new RemoveVideoFromPlaylist(playlist, vid));
	}
	
	public void undo() {
		exec.undo();
	}
	
	public void redo() {
		exec.redo();
	}
	
	public void getPlaylistStats() {
		System.out.println(playlist.getTotal());
		System.out.println(playlist.getViews());
		System.out.println(playlist.getLikes());
	}
	
}
