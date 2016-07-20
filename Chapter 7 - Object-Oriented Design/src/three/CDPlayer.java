package three;

import java.util.ArrayList;
import java.util.List;

public class CDPlayer {
	private List<CD> cds = new ArrayList<CD>();
	private Song currentSong;
	private double currentBalance;
	
	public String play(CD cd, String name) {
		Song song = cd.selectSong(name);
		if (currentBalance >= song.getPrice()) {
			currentSong = song;
			currentBalance -= song.getPrice();
			return "Play " + song.getName() + " from " + cd.getName();
		}
		return "Please insert " + (song.getPrice() - currentBalance)
				+ " to play the song";
	}
	
	public Song currentSong() { 
		return currentSong;
	}
	
	public void addMoney(double money) { 
		currentBalance += money;
	}
	
	public double getBalance() {
		return currentBalance;
	}
	
	
}
