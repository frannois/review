package review;


public class ThreadAddition {

    private Integer sum = 0;
    private int[] mArray;
    private int mNbOfThreads;

    public ThreadAddition(int[] array, int nbOfThreads) {
	mArray = array;
	mNbOfThreads = nbOfThreads;
    }

    public int sum() throws InterruptedException {
	int sizePerThread = mArray.length / mNbOfThreads;
	Exec[] threadPool = new Exec[mNbOfThreads];
	
	for (int i = 0 ; i < mNbOfThreads ; i++) {
	    threadPool[i] = new Exec(i*sizePerThread, i*sizePerThread+sizePerThread );
	    threadPool[i].run();
	}
	for (Thread i : threadPool) {
	    i.join();
	}
	
	return sum;
    }

    private void addToSum(int value) {
	synchronized (sum) {
	    sum += value;
	}
    }

    private class Exec extends Thread {

	private int mStart, mEnd;

	public Exec(int start, int end) {
	    mStart = start;
	    mEnd = end;
	}

	@Override
	public void run() {
	    int sum = 0;
	    for (int i = mStart; i < mEnd; i++) {
		sum += mArray[i];
	    }
	    addToSum(sum);
	}

    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
       int size = 5690110;
	int[] array = new int[size];
	for (int i = 0 ; i < size ; i++) {
	    array[i] = i+1;
	}
	long now = System.currentTimeMillis();
	ThreadAddition addition = new ThreadAddition(array, 5);
	try {
	    System.out.println(addition.sum());
	} catch (InterruptedException e) {
	}
	System.out.println(System.currentTimeMillis() - now);
    }

}
