package stringMatching;

public class NaiveAlgorithm {
	
	static void naive(String text,String pattern){
		int n = text.length();
		int m = pattern.length();
		if(m>n) {
			System.out.println("No matching pattern!");
			return;
		}
		//iterate over text by matching each charater of pattern of text 
		for(int i=0;i<=n-m;i++) {
			int j;
			//matching the pattern the character with the text
			//if any character suddenly don't match break the loop
			for(j=0;j<m;j++) {
				if(text.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			//if all the character of the pattern string matches with text
			// we print the index of the starting character in the text
			if(j==m) {
				System.out.println("The pattern start at index "+i);
			}
		}
	}
	public static void main(String[] args) {
		String text = "abcdefghidef";
		String pattern = "def";
		naive(text, pattern);
	}

}
