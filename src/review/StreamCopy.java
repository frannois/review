package review;

public class StreamCopy {

    
    public static void removeAt(int[] array, int pos) {
	
	int[] answer = new int[array.length - 1];
	System.arraycopy(array, 0, answer, 0, pos);
	System.arraycopy(array, pos+1, answer, pos, array.length - pos -1);
	
	for (int i : answer) {
	    System.out.print(i + " ");
	    
	}
	System.out.println();
    }
    
    
    public static void main(String[] args) {
	
	int[] myArray = new int[100];
	
	for (int i = 0 ; i < 100 ; i++) {
	    
	    myArray[i] = i;
	}
	
	removeAt(myArray, 65);
	for (int i : myArray) {
	    System.out.print(i + " ");
	    
	}
	System.out.println();
    }

}
