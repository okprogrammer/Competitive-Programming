package lect_13;

public class QuickSort {
	
	static void quicksort(int[] input,int start,int end) {
		if(start>=end) {
			return;
		}
		
		int partitionIndex = partition(input,start,end);
		quicksort(input,start,partitionIndex-1);
		quicksort(input,partitionIndex+1,end);
	}

	private static int partition(int[] input, int start, int end) {
		int i = start;
		int j = end;
		int pivot = input[i];
		while(i<j) {
			do {
				i++;
			}while(input[i]<=pivot);
			do {
				j--;
			}while(input[j]>pivot);
			if(i<j) {
				swap(input,i,j);
			}
		}
		swap(input,i,j);
		return j;
	}

	static void swap(int[] input,int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = {7,8,9,41,10,1,2,3,40,26,-999};
		quicksort(input,0,input.length-1);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}

	}

}
