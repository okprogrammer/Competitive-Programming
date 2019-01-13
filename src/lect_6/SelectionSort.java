package lect_6;

public class SelectionSort {
	//getting minimum Index
	static int getMinIndex(int[] input,int startIndex) {
		int minElement = Integer.MAX_VALUE;
		int minIndex=startIndex;
		for(int i=startIndex;i<input.length;i++) {
			if(input[i]<minElement) {
				minElement = input[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	//using minimum Index
	static void minSelectionSort(int[] input) {
		for(int i=0;i<input.length;i++) {
			int minIndex = getMinIndex(input,i);
			swap(input,i,minIndex);
		}
		for(int k=0;k<input.length;k++) {
			System.out.print(input[k]+" ");
		}
	}
  static void swap(int[] input,int i,int j) {
	  int temp = input[i];
	  input[i] = input[j];
	  input[j] = temp;
  }
	public static void main(String[] args) {
		int largest;
		int[] input = {7,6,5,3,2,1,0};
		for(int firstUnsortedIndex=input.length-1;firstUnsortedIndex>0;firstUnsortedIndex--) {
			largest = 0;
			for(int i = 1;i<=firstUnsortedIndex;i++) {
				if(input[i]>input[largest]) {
					largest = i;
				}
			}
			swap(input,firstUnsortedIndex,largest);
		}
		
		for(int j=0;j<input.length;j++) {
			System.out.println(input[j]);
		}
		minSelectionSort(input);

	}

}
