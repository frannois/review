/**
 * 
 */

package review;

import java.util.ArrayList;

/**
 * @author jfdionne
 */
public class QueueArrayList<T> {

    private static final int QUEUE_SIZE = 100;
    private ArrayList<T> array = new ArrayList<T>();

    public void insert(T value) {
        array.add(value);
    }

    public T remove() {
        T value = null;
        if(array.size() > 0)
        value = array.remove(0);
        return value;
    }

    public T peek() {
        return array.get(0);
    }

    private int size() {
        return array.size();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        QueueArrayList<Integer> mQueue = new QueueArrayList<Integer>();
        
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
