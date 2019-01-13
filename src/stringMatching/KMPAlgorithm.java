package stringMatching;

public class KMPAlgorithm {
	
	static void kmp(String pattern,String text){
		int n = text.length();
		int m = pattern.length();
		
		int[] lps = new int[m];
		//iterate for pattern
		int j=0;
		//compute lps array
		computeLPS(pattern,m,lps);
		int i=0;
		while(i<n) {
			//if character matches then we increase the index of both the string
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;
				j++;
			}
			//if last index of pattern equals to the m then print the index of 
			//text where string starts
			if(j==m) {
				System.out.println("this is the index for matching "+(i-j));
				j=lps[j-1];
			}
			//mismatches after j matches
			else if(i<n && pattern.charAt(j)!=text.charAt(i)) {
				if(j!=0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}
		}
	}

	 static void computeLPS(String pattern, int m, int[] lps) {
		
		 int len = 0;
		 int i=1;
		 lps[0] = 0;
		 while(i<m) {
			 if(pattern.charAt(i)==pattern.charAt(len)) {
				 len++;
				 lps[i] = len;
				 i++;
			 }else {
				 if(len!=0) {
					 len = lps[len-1];
				 }else {
					 lps[i] = len;
					 i++;
				 }
			 }
		 }
		
	}
	 public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";
		kmp(pattern,text);
	}

}
