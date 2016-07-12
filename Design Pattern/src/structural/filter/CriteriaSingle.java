package structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

	public List<Person> meetCriteria(List<Person> people) {
		List<Person> single = new ArrayList<Person>();
		for (Person person: people) {
			if (person.getMaritalStatus().equalsIgnoreCase("Single")) {
				single.add(person);
			}
		}
		return single;
	}
}
