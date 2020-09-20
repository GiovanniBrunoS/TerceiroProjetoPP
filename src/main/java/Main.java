import channel.Channel;
import dataacess.UserDAO;
import user.User;
import video.Video;
import video.group.VideoGroup;
import video.playlist.AddVideoToPlaylist;
import video.playlist.CommandExecuter;
import video.playlist.Playlist;
import video.playlist.PlaylistManager;

public class Main {

	public static void main(String[] args) {
		
		User user1 = UserDAO.getUser("João");
		User user2 = UserDAO.getUser("Maria");
		User user3 = UserDAO.getUser("Lucas");
		User user4 = UserDAO.getUser("Daiane");
		User user5 = UserDAO.getUser("Marcia");
				
		Channel ch1 = new Channel().ownedBy(user1).named("canal do joão");
		
		ch1.addSubscribers(user2);
		ch1.addSubscribers(user3);
		ch1.addSubscribers(user5);
		
		System.out.println("");
		
		VideoGroup group1 = new VideoGroup("DIY");
		group1.addVideo(ch1.newVideo("Primeiro video do canal"));	
		ch1.addGroup(group1);
		
		System.out.println("");
		
		ch1.getGroup().detailedDescription();
		
		System.out.println("");
		
		ch1.addSubscribers(user4);
		
		System.out.println("");
		
		ch1.applySponsored();
		ch1.applyVerified();
		ch1.applySponsored();
		
		System.out.println("");
		
		VideoGroup group2 = new VideoGroup("Vlog");
		group2.addVideo(ch1.newVideo("Segundo video do canal!"));
		ch1.addGroup(group2);
		
		System.out.println("");
		
		user2.watch(ch1);
		user3.watch(ch1);
		user4.watch(ch1);
		user5.watch(ch1);
		
		System.out.println("");
		
		ch1.getCopyright();
		ch1.getCopyright();
		ch1.applyStandart();
		
		System.out.println("");
		
		ch1.getGroup().detailedDescription();
		
		System.out.println("");
		
		PlaylistManager play = new PlaylistManager();
		
		for(Video video : ch1.getVideos()) {
			play.addVideo(video);
		}
		
		play.getPlaylistStats();
		
		System.out.println("");
		
		user2.watch(ch1);
		user3.watch(ch1);
		user4.watch(ch1);
		user5.watch(ch1);
		
		System.out.println("");
		
		play.getPlaylistStats();
		
		play.undo();
		play.undo();
		play.redo();
		play.redo();
		
		play.getPlaylistStats();
		
		System.out.println("");
		
		for(Video video : ch1.getVideos()) {
			video.getComments();
		}
			
	}
}
