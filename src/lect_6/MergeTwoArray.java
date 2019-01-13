package lect_6;

public class MergeTwoArray {
    static void mergeArray(int[] input1,int[] input2) {
    	int m = input1.length;
		int n = input2.length;
		int[] input = new int[m+n];
		int i=0,j=0,k=0;
		while(k<m+n) {
			while(i<m && j<n) {
				if(input1[i]<input2[j]) {
					input[k] = input1[i];
					i++;
				}
				else {
					input[k]=input2[j];
					j++;
				}
				k++;
			}
			while(i<m) {
				input[k]=input1[i];
				i++;
				k++;
			}
			while(j<n) {
				input[k]=input2[j];
				j++;
				k++;
			}
		}
		for(int l=0;l<input.length;l++) {
			System.out.print(input[l]+" ");
		}
    }
	public static void main(String[] args) {
		int[] input1 = {1,2,3,4,5};
		int[] input2 = {6,7,8};
		mergeArray(input1,input2);
	}

}
