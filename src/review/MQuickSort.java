package review;

import java.util.Collection;
import java.util.Random;

public final class MQuickSort {

    
    private MQuickSort(){}
    
    public static Integer[] sort(Integer[] c) {
	
	
	
	return quickSort(c, 0  , c.length);
    }
    
    private static Integer[] quickSort(Integer[] c, int start, int end) {
	
	int i = start;
	int j = end ;
	int tmp;
	int pivot = (end - start) / 2;
	
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
	    }
	}
	if(start < i -1 )
	quickSort(c, start, pivot);
	if(i < end )
	quickSort(c, pivot, end);

	return c;
    }

    public static void main(String[] args) {
	Integer[] ar = new Integer[5];
	Random a = new Random(System.currentTimeMillis());
	for (int i = 0 ; i < 5 ; i++) {
	    ar[i] = a.nextInt();
	    System.out.print(ar[i] + " ");
	}
	System.out.println();
        MQuickSort.sort(ar);
        for(int i : ar) {
            System.out.print(i + " ");
        }
    }

}
