import java.util.LinkedList;


public class Six {
	/*
	 * 
	 * Create a data structure to maintain a FIFO system and implement operations
	 * such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the 
	 * built-in LinkedList data structure 
	 * 
	 */
	
	/*
	 * 
	 * Book's answer.
	 * Note: 
	 * - Built-in LinkedList has following functions:
	 *  + addLast/ addFirst
	 *  + poll() to get the first out
	 * - Structure design: using extends for inheritance
	 * 
	 */
	private static class Animal {
		private int order;
		protected String name;
		public Animal (String name) {this.name = name;}
		
		public int getOrder() {
			return order;
		}
		
		public void setOrder(int order) {
			this.order = order;
		}
		
		public boolean isOlderThan(Animal other) {
			return this.order < other.order;
		}
	}
	
	private static class Cat extends Animal{
		public Cat (String name) {super(name);}
	}
	
	private static class Dog extends Animal{
		public Dog (String name) {super(name);}
	}
	
	private static class AnimalQueue {
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		int order = 0;
		
		public void enqueue(Animal animal) {
			animal.setOrder(order);
			order++;
			
			if (animal instanceof Cat) cats.addLast((Cat) animal);
			else if (animal instanceof Dog) dogs.addLast((Dog) animal);
		}
		
		public Animal dequeueAny() {
			if (dogs.size() == 0) 		return dequeueCats();
			else if (cats.size() == 0) 	return dequeueDogs();
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			
			if (dog.isOlderThan(cat)) 	return dequeueDogs();
			else 						return dequeueCats();
		} 
		
		public Dog dequeueDogs() {return dogs.poll();}	
		public Cat dequeueCats() {return cats.poll();}
	}
}
