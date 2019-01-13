 package lect_10;

public class KeyPadNumber {
	static String mapping(int i) {
		String[] keypadString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		return keypadString[i];
	}
	
	static String[] keypad(int n){
		// Write your code here
		if(n==0) {
			String[] s = {""};
			return s;
		}
		
		String[] smallAns = keypad(n/10);
		String word = mapping(n%10);
		String[] newStringArray = new String[smallAns.length*word.length()];
		int k=0;
		for(int i=0;i<word.length();i++) {
			for(int j=0;j<smallAns.length;j++) {
					newStringArray[k++] = smallAns[j]+word.charAt(i);
			}
		}
		return newStringArray;
		

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] input = keypad(439);
       for(int i=0;i<input.length;i++) {
    	   System.out.print(input[i]+" ");
       }
	}

}
