package review;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class NearestNeighbor {

    private static final Comparator<NearestNeighbor> COMPARATOR = new Comparator<NearestNeighbor>() {

	@Override
	public int compare(NearestNeighbor o1, NearestNeighbor o2) {
	    if (o1.number < o2.number) {
		return -1;
	    } else if (o2.number < o1.number) {
		return 1;
	    } else
		return 0;
	}

    };
    public final char name;
    public final int number;

    public NearestNeighbor(int nb, char n) {
	name = n;
	number = nb;
    }

    public static int[] findNeighbors(NearestNeighbor[] array, int personsNumber){
	
	Arrays.sort(array, COMPARATOR);
	int i = 0;
	while (array[i].number != personsNumber) {
	    i++;
	}
	int[] answer = new int[3];
	

	answer[0] = answer[1] = answer[2] = Integer.MIN_VALUE;
	
	for (int j = i -3 ; j < i + 4 ; j++) {
	    if( j >= 0 && j < array.length) {
		if(answer[0] < array[j].number) {
		    answer[2] = answer[1];
		    answer[1] = answer[0];
		    answer[0] = array[j].number;
		} else if (answer[1] < array[j].number) {
		    answer[2] = answer[1];
		    answer[1] = array[j].number;
		} else if (answer[2] < array[j].number) {
		    answer[2] = array[j].number;
		}
		
		
	    }
	}
	

	return answer;
	
    }

    @Override
    public String toString() {
	return name + " " + number;
    }

    public static void main(String[] args) {

	LinkedList<NearestNeighbor> list = new LinkedList<NearestNeighbor>();
	java.util.Random r = new java.util.Random(System.currentTimeMillis());
	for (int i = 0; i < 75; i++) {
	    list.add(new NearestNeighbor(r.nextInt(),
		    (char) (r.nextInt(26) + 'a')));
	}

	for (NearestNeighbor a : list) {
	    System.out.println(a.toString());
	}
	
	for (int a : findNeighbors(list.toArray(new NearestNeighbor[list.size()]), list.get(r.nextInt(list.size())).number)) {
	    System.out.print(a + " ");
	}
    }

}
