package lect_10;

public class PermutationString {
	static String[] permutationString(String input) {
		if(input.length()==0) {
			String[] arr = {""};
			return arr;
		}
		//here is the which we want every time
		//that this solution is available to us
		String[] smallAns = permutationString(input.substring(1));
		//size of the newly created array after every call
		String[] result = new String[smallAns.length*(smallAns[0].length()+1)];
		int k=0;
		for(int i=0;i<smallAns.length;i++) {
			String word = smallAns[i];
			for(int j=0;j<=word.length();j++) {
				result[k++] = word.substring(0,j)+input.charAt(0)+word.substring(j);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sub = permutationString("abc");
		for(int i=0;i<sub.length;i++) {
			System.out.println(sub[i]);
		}
	}

}
