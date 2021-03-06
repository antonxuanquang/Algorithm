package five;

import java.util.ArrayList;

public class User {
	
	private String name;
	private double ballance;
	private ArrayList<Book> books;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBallance() {
		return ballance;
	}

	public void setBallance(double ballance) {
		this.ballance = ballance;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void purchase(Book book) throws Exception {
		if (ballance > book.getPrice()) {
			books.add(book);
			ballance -= book.getPrice();
		} else {
			throw new Exception("Oops! You don't have enough money");
		}
	}

}
