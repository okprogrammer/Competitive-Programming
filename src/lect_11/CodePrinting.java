package lect_11;

public class CodePrinting {
	
	//mapping function to return the corresponding map
	static char mapping(int n) {
		char c = (char) ('a'+n-1);
		return c;
	}
	public static void getCode(String input,String resultSoFar){
		//base condition
		if(input.length()==0) {
			System.out.println(resultSoFar);
			return;
		}
		getCode(input.substring(1),resultSoFar+mapping(Character.getNumericValue(input.charAt(0))));
		
		if(input.length()>1) {
			int m = Integer.parseInt(input.substring(0, 2));
			if(m<=26) {
				getCode(input.substring(2),resultSoFar+mapping(m));
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		getCode("1223","");
	

	}

}
