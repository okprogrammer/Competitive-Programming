package lect_10;

public class SubsequencePrintString {
	static String[] subSequence(String input){
		if(input.length()==0) {
			String[] arr = {""};
			return arr;
		}
		
		String[] smallAns = subSequence(input.substring(1));
		String[] result = new String[smallAns.length*2];
		int k=0;
		//first time loop copy as such
		for(int i=0;i<smallAns.length;i++) {
			result[k++] =smallAns[i]; 
		}
		//second time loop copy with char at 0 attach
		for(int i=0;i<smallAns.length;i++) {
			result[i+smallAns.length] = input.charAt(0)+smallAns[i];
		}
		return result;
	}
	public static void main(String[] args) {
		String[] sub = subSequence("abc");
		for(int i=0;i<sub.length;i++) {
			System.out.println(sub[i]);
		}
	}

}
