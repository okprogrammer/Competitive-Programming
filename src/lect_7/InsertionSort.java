package lect_7;

public class InsertionSort {
	static void swap(int[] input,int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	static void insertionSort(int[] input) {
		for(int i=1;i<input.length;i++) {
			for(int j=i;j>0;j--) {
				if(input[j-1]>input[j]) {
					swap(input,j-1,j);
				}
				else {
					break;
				}
			}
		}
	}
public static void main(String[] args) {
	int[] input = {8,9,5,4,7,1,2};
	insertionSort(input);
	for(int k=0;k<input.length;k++) {
		System.out.print(input[k]+" ");
	}
	
}
}
