import java.util.Stack;

/**
 * http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
 *
 */
public class QueueUsingStacks {

	public static class QueueWithStacks {
		
		Stack<Integer> inbox = new Stack<Integer>();
		Stack<Integer> outbox = new Stack<Integer>();
		
		public void enqueue(Integer i) {
			inbox.push(i);
		}
		
		public Integer dequeue() {
			if(outbox.isEmpty()) {
				while(!inbox.isEmpty()) {
					outbox.push(inbox.pop());
				}
			}
			return outbox.pop();
		}
		
	}
	
	public static void main(String[] args) {
		
		QueueWithStacks qs = new QueueWithStacks();
		
		qs.enqueue(10);
		qs.enqueue(1);
		qs.enqueue(12);
		qs.enqueue(11);
		
		System.out.println(qs.dequeue());
		
		qs.enqueue(22);
		qs.enqueue(21);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
	}

}
