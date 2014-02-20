package review;

public class FindTheMedian {

    
    public static double findTheMedian(int[] array, int start, int end) {
	
	int pivot = array[(start+end)/2];
	int i = start;
	int j = end;
	int tmp;
	
	while (i < j) {
	    if(array[i] > pivot) {
		while(array[j] > pivot) {
		    j--;
		}
		tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
		i++;
		j--;
	    } else if (array[j] < pivot) {
		while(array[i] < pivot) {
		    i++;
		}
		tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
		i++;
		j--;
	    }
	    if (array[i] < pivot) {
		i++;
	    }
	    if (array[j] > pivot) {
		j--;
	    }
	}
	
	if(i > array.length/2) {
	    return findTheMedian(array, start, i);
	} else if (i < array.length /2) {
	    return findTheMedian(array, i+1, end);
	} else {
	    if(array.length/2 == 1) return array[i];
	    else return (double)(array[i]+array[i-1])/2 ;
	}
	
	
    }
    
    
    
    public static void main(String[] args) {
	int[] array = { 1 ,10, 3 , 4 , 5, 7, 6 ,8 , 9 };
	
	System.out.println(findTheMedian(array, 0, array.length-1));
    }
}
