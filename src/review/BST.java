package review;

import java.util.HashSet;
import java.util.Stack;

public final class BST {

    private class Node {
        
        public Integer value;
        public Node left = null;
        public Node right = null;
        
        public Node(Integer v) {
            value = v;
        }
        
    }

    public  boolean isBSTInOrder(Node head) {
        boolean answer = true;
        if(head.left != null) {
            answer = isBST(head.left);
            if (head.left.value > head.value) {
                return false;
            }
        }
        if(head.right != null) {
            answer = isBST(head.right);
            if (head.right.value <= head.value) {
                return false;
            }
        }
        return answer;
    }
    public  boolean isBST(Node head) {
        
        // this class should check if the tree is BST
        // and check if it has duplicates
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> values = new HashSet<Node>();
        stack.push(head);
        Node tmp;
        
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            if(tmp != null) {
                if(values.contains(tmp)) 
                    return false;
                else values.add(tmp);
                if(tmp.left != null) {
                    if (tmp.left.value > tmp.value) {
                        return false;
                    }
                    stack.add(tmp.left);
                }
                if (tmp.right != null) {
                    if (tmp.right.value < tmp.value) {
                        return false;
                    }
                    stack.add(tmp.right);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
