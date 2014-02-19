package review;


import java.util.Comparator;
import java.util.LinkedList;

/**
 * NOT WORKING
 * @author jfdionne
 *
 */
public class TallPeople {

    public int height;
    public int nBofTallPeople;
    public String name;
    
    public TallPeople(int h, int nT, String n) {
	height = h;
	nBofTallPeople = nT;
	name = n;
    }
    public static Comparator<TallPeople> COMPARATOR = new Comparator<TallPeople>() {
        
	
        @Override
        public int compare(TallPeople o1, TallPeople o2) {
    	    if(o1.nBofTallPeople != o2.nBofTallPeople) {
    		return o1.nBofTallPeople > o2.nBofTallPeople ? 1 : -1;
    	    } else if(o1.height != o2.height) {
    		    return o1.height > o2.height ? 1 : -1;
    	    }
    	    return 0;
        }
    };
    
    /*
     * we have a random list of people. each person knows his own height and the number of tall people in front of him. write a code to make the equivalent queue. 
for example : 
input: <"Height","NumberOfTall","Name">, 
<6,2,"A">,<1,4,"B">,<11,0,"C">,<5,1,"D">,<10,0,"E">,<4,0,"F"> 
output: "F","E","D","C","B","A" --> end of queue
     */
    
    
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	TallPeople[] array = new TallPeople[6];
	array[0] = new TallPeople(6, 2, "A");
	array[1] = new TallPeople(1, 4, "B");
	array[2] = new TallPeople(11, 0, "C");
	array[3] = new TallPeople(5, 1, "D");
	array[4] = new TallPeople(10, 0, "E");
	array[5] = new TallPeople(4, 0, "F");
	
	
	LinkedList<TallPeople> answer = new LinkedList<TallPeople>();
	for (int i = 0 ; i < array.length ; i++) {
	    System.out.print(array[i].name);
	}
	answer.add(array[0]);
	int i = 1;
	while ( answer.size() != array.length) {
	}

    }

}
