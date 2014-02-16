package review;

import java.util.Random;

public final class MMergeSort {

    private MMergeSort() {
    }

    public static Integer[] sort(Integer[] c) {
	return mergeSort(c);
    }

    private static Integer[] mergeSort(Integer[] c) {

	int length = c.length / 2;
	Integer[] fHalf = new Integer[length];
	Integer[] sHalf = new Integer[c.length - length];
	System.arraycopy(c, 0, fHalf, 0, fHalf.length);
	System.arraycopy(c, length, sHalf, 0, sHalf.length);
	return merge(mergeSort(sHalf), mergeSort(fHalf));

    }

    private static Integer[] merge(Integer[] mergeSort, Integer[] mergeSort2) {
	Integer[] merged = new Integer[mergeSort.length + mergeSort2.length];
	int i = 0;
	int j = 0;
	int k = 0;
	while (i < mergeSort.length || j < mergeSort2.length) {
	    if (i < mergeSort.length && j < mergeSort2.length) {
		if (mergeSort[i] < mergeSort2[j]) {
		    merged[k] = mergeSort[i];
		    i++;
		    k++;
		} else {
		    merged[k] = mergeSort[j];
		    j++;
		    k++;
		}
	    } else if (i < mergeSort.length) {
		merged[k] = mergeSort[i];
		    i++;
		    k++;
	    } else {
		merged[k] = mergeSort[j];
		    j++;
		    k++;
	    }
	}

	return merged;
    }

    public static void main(String[] args) {
	Integer[] ar = new Integer[5];
	int prev;
	Random a = new Random(System.currentTimeMillis());
	for (int i = 0; i < 5; i++) {
	    ar[i] = a.nextInt();
	    System.out.print(ar[i] + " ");
	}
	System.out.println();
	MMergeSort.sort(ar);
	prev = ar[0];
	System.out.print(ar[0] + " ");
	for (int i = 1; i < 5; i++) {
	    if (prev < ar[i]) {
		System.out.print(ar[i] + " ");
		prev = ar[i];
	    } else {
		System.out.print("Error");
		System.out.print(ar[i] + " ");
		prev = ar[i];
	    }
	}
    }

}
