package todo;

import java.util.HashMap;

//TODO: ALGO
public class TreeFromPreOrderInOrder {

	
	public static void main() { 
		
		HashMap<String, String> al = new HashMap<String, String>();
		al.put("a", "b");
		al.put("a1", "b1");
		al.put("a2", "b2");
		
		for(String s : al.keySet()) {
			System.out.println("First " + s);
		}
		
	}
	
}
