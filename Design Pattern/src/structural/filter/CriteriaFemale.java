package structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	public List<Person> meetCriteria(List<Person> people) {
		List<Person> female = new ArrayList<Person>();
		for (Person person: people) {
			if (person.getGender().equalsIgnoreCase("female")) {
				female.add(person);
			}
		}
		return female;
	}
}
