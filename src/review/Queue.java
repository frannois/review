/**
 * 
 */

package review;

/**
 * @author jfdionne
 */
public class Queue<T> {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void insert(T value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;

    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    private int size() {
        return size;
    }
    
    private class Node {

        public T value;
        public Node next = null;

        public Node(T v) {
            value = v;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Queue<Integer> mQueue = new Queue<Integer>();
        
        System.out.println(mQueue.size());
        mQueue.remove();
        mQueue.insert(4);
        System.out.println(mQueue.size());
        mQueue.insert(3);
        mQueue.insert(2);
        mQueue.insert(1);
        System.out.println(mQueue.size());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        
    }



}
