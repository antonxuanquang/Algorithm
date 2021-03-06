package three;

import java.util.ArrayList;
import java.util.List;

public class CD {
	
	private List<Song> list = new ArrayList<Song>();
	private String name;
	
	public CD(List<Song> songs, String name) {
		list = songs;
		this.name = name;
	}
	
	public Song selectSong(String name) {
		for (Song song: list) {
			if (song.getName().equalsIgnoreCase(name)) return song;
		}
		return null;
	}
	
	public String getName() {
		return name;
	}

}
