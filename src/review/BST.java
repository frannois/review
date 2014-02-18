package review;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public final class BST {

    private Node head = null;

    private class Node {

	public Integer value;
	public Node left = null;
	public Node right = null;

	public Node(Integer v) {
	    value = v;
	}

    }

    public boolean isBSTInOrder(Node head) {
	boolean answer = true;
	if (head.left != null) {
	    answer = isBSTInOrder(head.left);
	    if (head.left.value > head.value) {
		return false;
	    }
	}
	if (head.right != null) {
	    answer = isBSTInOrder(head.right);
	    if (head.right.value <= head.value) {
		return false;
	    }
	}
	return answer;
    }

    public boolean isBST() {

	// this class should check if the tree is BST
	// and check if it has duplicates
	LinkedList<Node> queue = new LinkedList<Node>();
	HashSet<Node> values = new HashSet<Node>();
	queue.add(head);
	Node tmp;

	while (!queue.isEmpty()) {
	    tmp = queue.removeLast();
	    if (tmp != null) {
		if (values.contains(tmp))
		    return false;
		else {
		    values.add(tmp);
		}
		if (tmp.left != null) {
		    if (tmp.left.value > tmp.value) {
			return false;
		    }
		    queue.add(tmp.left);
		}
		if (tmp.right != null) {
		    if (tmp.right.value < tmp.value) {
			return false;
		    }
		    queue.add(tmp.right);
		}
	    }
	}
	return true;
    }

    @SuppressWarnings("unused")
    private void insert(int value, Node head) {
	if (head == null) {
	    head = new Node(value);
	} else if (value < head.value) {
	    insert(value, head.left);
	} else if (value > head.value) {
	    insert(value, head.right);
	}
    }
    
    private void insert(int value) {

	if(head == null) {
	    head = new Node(value);
	} else {
	    Node tmp = head;
	    while(tmp != null) {
		if(value < tmp.value) {
		    if(tmp.left == null) {
			tmp.left = new Node(value);
			return;
		    } else {
			tmp = tmp.left;
		    }
		} else if (value > tmp.value) {
		    if(tmp.right == null) {
			tmp.right = new Node(value);
			return;
		    } else {
			tmp = tmp.right;
		    }
		} else return;
	    }
	    
	}
    }

    private static void printTree(Node head) {
	if(head == null) return;
	int size;
	Node tmp;
	LinkedList<Node> queue = new LinkedList<BST.Node>();
	queue.add(head);
	while(!queue.isEmpty()) {
	    size = queue.size();
	    for (int i = 0 ; i < size ; i++) {
		tmp = queue.remove();
		System.out.print(tmp.value + " ");
		if(tmp.left != null) {
		    queue.add(tmp.left);
		}
		if (tmp.right != null) {
		    queue.add(tmp.right);
		}
	    }
	    System.out.println();
	}
    }
    private static void replaceAllValuesBySumOfParents(Node head) {
	rAVBSOP(head,0);
    }
    private static void rAVBSOP(Node head, int value) {
	
	if(head.left != null) {
	    rAVBSOP(head.left, value + head.value);
	} 
	if (head.right != null) {
	    rAVBSOP(head.right, value + head.value);
	}
	head.value = value;
    }
    public static void main(String[] args) {

	final int SIZE = 10;
	BST mBST = new BST();
	java.util.Random r = new Random(System.currentTimeMillis());

	for (int i = 0; i < SIZE; i++) {
	    int v = r.nextInt()%10;
	    System.out.print(v + " ");
	    mBST.insert(v);
	}
	System.out.println();
	System.out.println(mBST.isBST());
	System.out.println(mBST.isBSTInOrder(mBST.head));
	printTree(mBST.head);
	replaceAllValuesBySumOfParents(mBST.head);
	System.out.println();System.out.println();System.out.println();
	printTree(mBST.head);
    }

}
