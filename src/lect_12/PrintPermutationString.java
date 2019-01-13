package lect_12;

public class PrintPermutationString {
	
   static void printPermuation(String input,String resultSoFar) {
	   if(input.length()==0) {
		   System.out.println(resultSoFar);
		   return;
	   }
	   for(int i=0;i<input.length();i++) {	   
		   printPermuation(input.substring(0, i)+input.substring(i+1),resultSoFar+input.charAt(i));
	   }
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermuation("abc","");
		

	}

}
