package lect_7;

public class StringPractice {
    static void printStringCharacter(String s) {
    	for(int i=0;i<s.length();i++) {
    		System.out.println(s.charAt(i));
    	}
    }
	public static void main(String[] args) {
		String s = "Hello";
		printStringCharacter(s);
	}

}
