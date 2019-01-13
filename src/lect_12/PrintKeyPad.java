package lect_12;

public class PrintKeyPad {
	//mapping function to return string corresponding to a number
	static String mapping(int i){
	    String[] keypadString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	    return keypadString[i];
	  }
	
	
	
	static void printKeyPad(int num,String resultSoFar) {
		if(num==0) {
			System.out.println(resultSoFar);
			return;
		}
		
		String test = mapping(num%10);
		for(int i=0;i<test.length();i++) {
			printKeyPad(num/10,test.charAt(i)+resultSoFar);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printKeyPad(23,"");

	}

}
