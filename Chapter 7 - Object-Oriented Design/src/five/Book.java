package five;

import java.util.ArrayList;

public class Book {
	
	private String title, author, content, id;
	private ArrayList<String> topics;
	private double price;
	
	public Book(String id) {
		this.id = id;
		topics = new ArrayList<String>();
	}
	
	public void setTopics(String... topics) {
		for (String topic: topics) {
			this.topics.add(topic);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<String> getTopics() {
		return topics;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTopics(ArrayList<String> topics) {
		this.topics = topics;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}
	
	

}
