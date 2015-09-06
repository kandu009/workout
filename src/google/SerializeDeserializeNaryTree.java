package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.careercup.com/question?id=4868040812396544
 *
 * Serialize an N-ary tree from machine A and de-serialize in machine B.
 * 
 * struct Node{
 *  string val;
 *  vector<Node*> sons;
 * }
 */
public class SerializeDeserializeNaryTree {
  
  public static class Node {
    Node(int value) {
      val_ = value;
      children_ = new ArrayList<Node>();
    }
    Node(int value, ArrayList<Node> children) {
      val_ = value;
      children_ = new ArrayList<Node>(children);
    }
    int val_;
    ArrayList<Node> children_;
  }
  
  /**
   * Perform a BFS traversal of the tree, but print the children count of 
   * a node before printing the children themselves. 
   * So, serializing is just doing a BFS, attaching the number of children before
   * actually printing the children.
   * 
   * Example for a tree of integers (applies similarly to a tree of strings). 
   * If you have this tree:
   * 
   * 1 5 2 3 4 5 6 3 7 8 9 1 10 2 11 12 0 3 13 14 15 0 0 0 0 0 0 0 0 0
   * 
   * The root is 1. 1 has 5 children; they are 2, 3, 4, 5 and 6.
   * 2 has 3 children; they are 7, 8, 9
   * 3 has 1 child; it is 10
   */
  public static String getSerializedString(Node root) {

    if(root == null) {
      return "";
    }
    
    StringBuilder serString = new StringBuilder();
    ArrayBlockingQueue<Node> sQueue = new ArrayBlockingQueue<Node>(100);
    
    try {
      
      sQueue.put(root);
      
      while(!sQueue.isEmpty()) {
        Node current = sQueue.poll();
        serString.append(current.val_);
        if(current.children_ != null) {
          serString.append(" ").append(current.children_.size()).append(" ");
          for(Node c : current.children_) {
            sQueue.put(c);
            serString.append(c.val_).append(" ");
          }
        } else {
          serString.append(" ").append(0).append(" ");
        }
      }
      
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    return serString.toString();
  }
  
  /**
   * Initialize the queue with the first node read. Then until the queue becomes empty, dequeue a
   * node, read the children count from input, and then read that same amount of nodes and enqueue them
   * as you read them.
   */
  public static void deSerializeString(String serString) {
    
    String[] toks = serString.split(" ");
    int i = 0;  // index to the array which is serialized string tokens.
    
    ArrayBlockingQueue<Node> desQueue = new ArrayBlockingQueue<Node>(100);
    Node root = new Node(Integer.parseInt(toks[i++]));
    try {
      desQueue.put(root);
      while(!desQueue.isEmpty() && i < toks.length) {
        Node current = desQueue.poll();
        int numberOfChildren = Integer.parseInt(toks[i++]);
        for(int j = 0; j < numberOfChildren; ++j) {
          Node c = new Node(Integer.parseInt(toks[i++]));
          current.children_.add(c);
          desQueue.put(c);
        }
        ++i;
      }
      
    } catch (InterruptedException e) {
      // TODO(rkandur): Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    
    Node root = new Node(1);

    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    
    root.children_ = new
        ArrayList<Node>(Arrays.asList(two, three, four, five));
    
    Node six = new Node(6);
    Node seven = new Node(7);
    Node eight = new Node(8);
    Node nine = new Node(9);
    
    two.children_ = new ArrayList<Node>(Arrays.asList(six, seven, eight, nine));
    
    Node ten = new Node(10);
    Node eleven = new Node(11);
    Node twelve = new Node(12);
    Node thirt = new Node(13);
    
    three.children_ = new ArrayList<Node>(Arrays.asList(ten, eleven, twelve, thirt));
    
    Node fourt = new Node(14);
    Node fift = new Node(15);
    Node sixt = new Node(16);
    Node sevent = new Node(17);
    
    four.children_ = new ArrayList<Node>(Arrays.asList(fourt, fift, sixt, sevent));
    
    Node eightt = new Node(18);
    Node nint = new Node(19);
    Node twenty = new Node(20);
    Node twenty1 = new Node(21);
    
    five.children_ = new ArrayList<Node>(Arrays.asList(eightt, nint, twenty, twenty1));
    
    String serString = getSerializedString(root);
    deSerializeString(serString);
    
  }
}

