package structural.adapter;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Play mp3. Name: " + fileName);
		} else if (audioType.equalsIgnoreCase("mp4") 
				|| audioType.equalsIgnoreCase("vlc")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}

}