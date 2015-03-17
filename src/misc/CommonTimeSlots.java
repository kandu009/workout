package misc;
import java.util.HashMap;
import java.util.HashSet;

import javafx.util.Pair;

/**
 * http://www.careercup.com/question?id=5146871133634560
 * 
 * This can be boiled down to other variants of 1. find all the duplicate
 * elements present in all the sets. 2. Find email addresses present in all
 * lists
 * 
 * We will maintain a Map of SlotInterval vs countOfAvailability. Then the
 * result would be the elements which have a countOfAvailability of >=
 * numberOfPersons.
 * 
 */
public class CommonTimeSlots {

	public static class Person {
		
		static int idCount = 1;
		
		int id_;
		HashSet<Pair<Integer, Integer>> slots_;
		
		public Person() {
			id_ = idCount;
			slots_ = new HashSet<Pair<Integer,Integer>>();
			++idCount;
		}
	}
	
	private static HashMap<Integer, Integer> findCommonSlots(HashSet<Person> persons) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for(Person p : persons) {
			for(Pair<Integer, Integer> s : p.slots_) {
				for(int i = s.getKey(); i < s.getValue(); ++i) {
					if(res.containsKey(i)) {
						res.put(i, res.get(i)+1);
					} else {
						res.put(i, 1);
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {

		Person p1 = new Person();
		p1.slots_.add(new Pair<Integer, Integer>(1, 2));
		p1.slots_.add(new Pair<Integer, Integer>(3, 4));
		p1.slots_.add(new Pair<Integer, Integer>(7, 8));
		
		Person p2 = new Person();
		p2.slots_.add(new Pair<Integer, Integer>(1, 5));
		p2.slots_.add(new Pair<Integer, Integer>(7, 10));
		p2.slots_.add(new Pair<Integer, Integer>(12, 13));
		
		Person p3 = new Person();
		p1.slots_.add(new Pair<Integer, Integer>(2, 4));
		p1.slots_.add(new Pair<Integer, Integer>(7, 13));
		p1.slots_.add(new Pair<Integer, Integer>(14, 15));
		
		HashSet<Person> persons = new HashSet<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		HashMap<Integer, Integer> result = findCommonSlots(persons);
		for(Integer p : result.keySet()) {
			if(result.get(p) >= persons.size()) {
				int end = p+1;
				System.out.println("Slot { " + p + " -> " + end + " }");
			}
		}
				
	}

}
