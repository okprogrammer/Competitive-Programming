package lect_8;

public class ArrayZeroOne {
	static void swap(int[]arr ,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//whenever we don't get zero at start index and one at end index
	//swap the start index and end index
	static void sort01(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			if(arr[start]==0) {
				start++;
			}
			else if(arr[end]==1) {
				end--;
			}
			else {
				swap(arr,end,start);
				start++;
				end--;
			}
		}
	}
	//whenever we get zero at ith index we swap with nextZero index
	static void AnotherSort01(int[] arr) {
		int i=0;
		int nextZero = 0;
		while(i<arr.length) {
			if(arr[i]==0) {
				swap(arr,i,nextZero);
				nextZero++;
			}
			i++;
		}
	}
	public static void main(String[] args) {
		int[] input = {0,1,0,1,0,0,1,1,0,1,1,0,1};
		int[] input1 = {0,1,1,1,0,1,1,1,0,1,1,0,1};
		AnotherSort01(input);
		sort01(input1);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println("");
		for(int i=0;i<input1.length;i++) {
			System.out.print(input1[i]+" ");
		}
	}

}
