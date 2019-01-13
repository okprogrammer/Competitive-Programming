package lect_8;

public class SearchInSortedMatrix {
	static boolean findElement(int[][] input,int searchElement) {
		int m = input.length;
		int n = input[0].length;
		int i=0,j=n-1;
		while(i<m && j>=0) {
			if(searchElement>input[i][j]) {
				i++;
			}
			else if(searchElement<input[i][j]) {
				j--;
			}
			else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		 int[][] input = { {10, 20, 30, 40},
                           {15, 25, 35, 45},
                           {27, 29, 37, 48},
                           {32, 33, 39, 50}};
		 System.out.println(findElement(input,50));

	}

}
