package structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

	public List<Person> meetCriteria(List<Person> people) {
		List<Person> male = new ArrayList<Person>();
		for (Person person: people) {
			if (person.getGender().equalsIgnoreCase("male")) {
				male.add(person);
			}
		}
		return male;
	}
}
