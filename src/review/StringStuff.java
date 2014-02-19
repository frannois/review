package review;

import java.util.ArrayList;

public class StringStuff {

    
    public static ArrayList<String> findPermutations(String a) {
	ArrayList<String> answer = new ArrayList<String>();
	if(a.length() == 1) {
	    answer.add(a);
	    return answer;
	}
	    
	ArrayList<String> tmp;
	
	for(int i = 0 ; i < a.length() ; i++) {
	   tmp =  findPermutations(a.substring(0, i)+a.substring(i+1));
	   for ( int j = 0; j < tmp.size() ; j++) {
	       tmp.set(j,  a.charAt(i) + tmp.get(j));
	   }
	   answer.addAll(tmp);
	}
	return answer;
    }
    
    public static ArrayList<String> findPermutationsIT(String a){
	int i = a.length();
	int size = 1;
	while (i > 0) {
	    size *= i;
	    i--;
	}
	
	ArrayList<String> answer = new ArrayList<String>(size);
	
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	ArrayList<String> array = findPermutations("dsage");
	
	for (String i : array) {
	    System.out.println(i);
	}
	System.out.println(array.size());
    }

}
