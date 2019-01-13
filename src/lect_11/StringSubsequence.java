package lect_11;

public class StringSubsequence {
	static void printSubSequence(String input,String resultSoFar){
		if(input.length()==0) {
			System.out.println(resultSoFar);
			return;
		}
		printSubSequence(input.substring(1),resultSoFar);
		printSubSequence(input.substring(1),resultSoFar+input.charAt(0));
		
	}
public static void main(String[] args) {
	String input = "abc";
	printSubSequence(input,"");
}
}
