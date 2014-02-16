package review;

public class removeCharFromString {

    
    public static String removeChar(String a, int pos) {
	StringBuilder ans = new StringBuilder();
	if(pos > a.length()) return a;
	if(pos != 0) {
	  ans.append(a.substring(0,pos));
	}
	ans.append(a.substring(pos+1, a.length()));
	
	return ans.toString();
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
       System.out.println(removeChar("I want to remove a char", 0));
       System.out.println(removeChar("I want to remove a char", 7));
       System.out.println(removeChar("I want to remove a char", 123));
       System.out.println(removeChar("I want to remove a char", "I want to remove a char".length()-1));
    }

}
