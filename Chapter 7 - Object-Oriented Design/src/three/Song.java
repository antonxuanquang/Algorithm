package three;

public class Song {
	private String name;
	private String title;
	private String author;
	private double price;
	
	public Song(String name, String title, String author, int price) {
		this.name = name;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}



}
