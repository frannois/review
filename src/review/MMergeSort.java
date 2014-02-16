package review;

import java.util.Random;

public final class MMergeSort {

    
    private MMergeSort(){}
    
    public static Integer[] sort(Integer[] c) {
	return quickSort(c, 0  , c.length -1);
    }
    
    private static Integer[] quickSort(Integer[] c, int start, int end) {
	
	if(end - start  <= 1) return c;
	int i = start;
	int j = end ;
	int tmp;
	int pivot = c[(end + start) / 2];
	
	while (i <= j) {
	    while(c[i] < pivot) {
		i++;
	    }
	    while(c[j] > pivot) {
		j--;
	    }
	    if(i <= j) {
		tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
		i++;
		j--;
	    }
	}
	if(start < j )
	quickSort(c, start, j);
	if(i < end  )
	quickSort(c, i  , end);

	return c;
    }

    public static void main(String[] args) {
	Integer[] ar = new Integer[5];
	int prev;
	Random a = new Random(System.currentTimeMillis());
	for (int i = 0 ; i < 5 ; i++) {
	    ar[i] = a.nextInt();
	    System.out.print(ar[i] + " ");
	}
	System.out.println();
        MMergeSort.sort(ar);
        prev = ar[0];
        System.out.print(ar[0] + " ");
        for (int i = 1 ; i < 5 ; i++) {
            if ( prev < ar[i]) {
            System.out.print(ar[i] + " ");
            prev = ar[i];
            }
            else {
        	System.out.print("Error");
                System.out.print(ar[i] + " ");
                prev = ar[i];
            }
        }
    }

}
