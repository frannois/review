package review;

public class StringAndInt {

    
    public static int StringToInt(String number)  {
	if (number == null || number.length() == 0) return -1;
	boolean negative = false;
	int answer = 0;
	int i = 0;
	if(number.charAt(0) == '-') {
	    negative = true;
	    i = 1;
	}
	while ( i < number.length()) {
	    answer *= 10;
	    answer += Integer.valueOf(Character.getNumericValue(number.charAt(i)));
	    i++;
	}
	
	if(negative) {
	    answer *= -1;
	}
	return answer;
    }
    
    public static String intToString(int value) {
	StringBuilder ans = new StringBuilder();
	boolean negative = false;
	if(value < 0 ) {
	    negative = true;
	    value *= -1;
	}
	
	while (value > 0) {
	    ans.append(value%10);
	    value  = value / 10;
	}
	if (negative) 
	    ans.append('-');
	return ans.reverse().toString();
    }
    public static void main(String[] args) {
	System.out.println(StringToInt("12000"));
	System.out.println(StringToInt("-12020"));

	int a = 12000;
	System.out.println(intToString(a));
	System.out.println(a);
	System.out.println(intToString(-234));
    }

}
