/**
 * 
 */

package review;


/**
 * @author jfdionne
 */
public class QueueArray {

    private static final int QUEUE_SIZE = 4;
    private int tail = 0;
    private int head = 0;
    private int[] array = new int[QUEUE_SIZE];
    private int size = 0;

    public void insert(int value) {
        if(size == 0) { //reset array
            tail = 0;
            head = 0;
        }
        if(tail < QUEUE_SIZE) {
          array[tail] = value;
        } else if (head > 0) { // check if we have some space left at the beginning of the array
            tail = 0;
            array[tail] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        tail++;
        size++;
    }

    public int remove() {
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int value;
        if (head < QUEUE_SIZE) {
           value = array[head];
           array[head] = -1;
        } else if (tail < head) {
           head = 0;
           value = array[head];
           array[head] = -1;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        head++;
        size--;
        return value;
    }

    public int peek() {
        return array[head];
    }

    private int size() {
        return size;
    }
    
    private void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        QueueArray mQueue = new QueueArray();
        
        System.out.println(mQueue.size());
        mQueue.insert(4);
        System.out.println(mQueue.size());
        mQueue.insert(3);
        mQueue.insert(2);
        mQueue.printArray();
        System.out.println(mQueue.remove());
        mQueue.insert(1);
        mQueue.printArray();
        System.out.println(mQueue.size());
        mQueue.insert(8);
        mQueue.printArray();
        System.out.println(mQueue.remove());
        mQueue.printArray();
        mQueue.insert(7);
        mQueue.printArray();
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        mQueue.insert(9);
        mQueue.printArray();
        mQueue.insert(10);
        mQueue.insert(11);
        mQueue.printArray();
        
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        System.out.println(mQueue.remove());
        mQueue.insert(12);
        mQueue.printArray();
        System.out.println(mQueue.remove());
        
    }



}
