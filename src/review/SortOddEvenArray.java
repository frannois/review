package review;

/**
 * sort the array so that the odd number in front of the even number and their relative order doesn't change in Time O(n) and Space O(1). I believe quickselect can do this, but it will change the relative order of the input.
 * @author jfdionne
 *
 */
public class SortOddEvenArray {

    public static int[] sort(int[] array) {
	int[] answer = new int[array.length];
	int i = 0, pos = 0;
	for ( i = 0 ; i <array.length ; i++) {
	    if(array[i] % 2 != 0) 
		answer[pos++] = array[i];
	}
	for ( i = 0 ; i <array.length ; i++) {
	    if(array[i] % 2 == 0) 
		answer[pos++] = array[i];
	}
	return answer;
    }
    
    
    public static void main(String[] args) {
	int[] array = {1 , 2 ,3 ,4 ,5 ,6,7};
	array = sort(array);
	for (int i : array) {
	    System.out.print(i + " ");
	}
    }
}
