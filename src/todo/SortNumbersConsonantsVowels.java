package todo;

/**
 * http://www.careercup.com/question?id=16343721
 * 
 * 
 * &******************NOT WORKING !!!! ****************
 * @author rkandur
 *
 */
public class SortNumbersConsonantsVowels {

	public static class Node {
		char data_;
		Node next_;
		
		public Node(char data) {
			data_ = data;
			next_ = null;
		}
	}
	
	public static void swapNodes(Node p1, Node n1, Node p2, Node n2) {
		
		if(n1.equals(n2)) {
			return;
		}
		
		Node n1Next = n1.next_;
		Node n2Next = n2.next_;
		p2.next_ = n1;
		p2.next_.next_ = n2Next;
		
		if(p1 == null) {
			n1 = n2;
			n1.next_ = n1Next;
		} else {
			p1.next_ = n2;
			p1.next_.next_ = n1Next;
		}
	}
	
	public static void reOrderNodes(Node head) {
		
		Node scurr = head;
		Node sprev = null;
		
		Node rcurr = head;
		Node rprev = null;
		
		while(scurr != null) {
			if(scurr.data_-48 <= 9 && scurr.data_-48 >= 0) {
				swapNodes(rprev, rcurr, sprev, scurr);
				Node temp = scurr;
				scurr = rcurr;
				rcurr = temp;
				sprev = scurr;
				scurr = scurr.next_;
				rprev = rcurr;
				rcurr = rcurr.next_;
				continue;
			} else {
				sprev = scurr;
				scurr = scurr.next_;
			}
		}
		
		scurr = rcurr;
		sprev = rprev;
		
		while(scurr != null) {
			if(isConsonant(scurr.data_)) {
				Node temp = scurr;
				scurr = rcurr;
				rcurr = temp;
				sprev = scurr;
				scurr = scurr.next_;
				rprev = rcurr;
				rcurr = rcurr.next_;
				continue;
			} else {
				sprev = scurr;
				scurr = scurr.next_;
			}
		}
		
	}
	
	private static boolean isConsonant(char data_) {

		if (data_ == 'a' || data_ == 'A' || data_ == 'e' || data_ == 'E'
				|| data_ == 'i' || data_ == 'I' || data_ == 'o' || data_ == 'O'
				|| data_ == 'u' || data_ == 'U') {
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Node head = new Node('a');
		Node b = new Node('b');
		Node one = new Node('1');
		Node e = new Node('e');
		Node f = new Node('f');
		Node two = new Node('2');
		
		head.next_ = b;
		b.next_ = one;
		one.next_ = e;
		e.next_ = f;
		f.next_ = two;
		
		reOrderNodes(head);
		
		while(head != null) {
			System.out.println(head.data_);
			head = head.next_;
		}

	}

}
