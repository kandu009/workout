package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class TopologicalSort {

	public static HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
	
	static void TopologicalSortUtil(Vector<Boolean> visited, Stack<Integer> tempStack, int i) {
		
		System.out.println(adjList.toString());
		
		visited.add(i, Boolean.TRUE);
		ArrayList<Integer> l = adjList.get(i);
		for(Integer a : l) {
			if(!visited.get(a)) {
				TopologicalSortUtil(visited, tempStack, a);
			}
		}
		
		tempStack.push(i);
	}
	
	static void TopologicalSortMethod(Stack<Integer> tempStack, int i) {
		
		System.out.println(adjList.toString());
		System.out.println(adjList.size());
		
		Vector<Boolean> visited = new  Vector<Boolean>(adjList.size());
		for(int vi=0; vi < visited.capacity(); ++vi) {
			visited.add(vi, Boolean.FALSE);
		}
		
		TopologicalSortUtil(visited, tempStack, i);
		
		while(tempStack.isEmpty()) {
			System.out.println(tempStack.pop());
		}
		
	}
	
	public static void main(String[] args) {

		adjList.put(0, new ArrayList<Integer>(Arrays.asList(1, 2)));
		adjList.put(1, new ArrayList<Integer>(Arrays.asList(3)));
		adjList.put(2, new ArrayList<Integer>(Arrays.asList(4)));
		adjList.put(3, new ArrayList<Integer>());
		adjList.put(4, new ArrayList<Integer>());

		System.out.println(adjList.toString());
		
		Stack<Integer> tempStack = new Stack<Integer>();
		
		for(int i =0; i < adjList.size(); ++i) {
			TopologicalSortMethod(tempStack, i);
		}
		
	}

}
