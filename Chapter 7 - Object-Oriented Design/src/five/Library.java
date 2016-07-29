package five;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(String id) {
		for (Book book: books) {
			if (book.getId().equals(id)) {
				books.remove(book);
			}
		}
	}
	
	public ArrayList<Book> findByAuthor(String keyword) {
		ArrayList<Book> results = new ArrayList<Book>();
		for (Book book: books) {
			if (book.getAuthor().contains(keyword)) {
				results.add(book);
			}
		}
		return results;
	}
	
	public ArrayList<Book> findByTopic(String topic) {
		ArrayList<Book> results = new ArrayList<Book>();
		for (Book book: books) {
			if (book.getTopics().contains(topic)) {
				results.add(book);
			}
		}
		return results;
	}
	
	public ArrayList<Book> findByTitle(String title) {
		ArrayList<Book> results = new ArrayList<Book>();
		for (Book book: books) {
			if (book.getTitle().contains(title)) {
				results.add(book);
			}
		}
		return results;
	}
}
