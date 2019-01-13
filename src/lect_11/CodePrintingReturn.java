package lect_11;

public class CodePrintingReturn {
	
	 public static char mapping(int n) {
	        char c = (char) ('a'+n-1);
	        return c;
	    }
	 public static  String[] getCode(String input){
			// Write your code here
		   if(input.length()<=0) {
			   String[] arr = {""};
			   return arr;
		   }
		   if(input.length()==1) {
			   String str =""+mapping(Integer.parseInt(input.substring(0))); 
			   String[] arr = {str};
			 return arr;
		   }
			String[] smallAns1 =getCode(input.substring(1));
			String[] smallAns2 = getCode(input.substring(2));	
			String[] result;
			int c = (input.charAt(0)-'0')*10+(input.charAt(1)-'0');
			if(c>9 && c<27) {
				result = new String[smallAns1.length+smallAns2.length];
				for(int i=0;i<smallAns1.length;i++) {
					result[i] = mapping(Character.getNumericValue(input.charAt(0)))+smallAns1[i];
				}
				for(int i=0;i<smallAns2.length;i++) {
					result[i+smallAns1.length] = mapping(c)+smallAns2[i];
				}
				return result;
			}
			else {
				result = new String[smallAns1.length];
				for(int i=0;i<smallAns1.length;i++) {
					result[i] = mapping(Character.getNumericValue(input.charAt(0)))+smallAns1[i];
				}
				return result;
			}
			
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String[] input = getCode("1123");
         for(int i=0;i<input.length;i++) {
        	 System.out.println(input[i]);
         }
	}

}
