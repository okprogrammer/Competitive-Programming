package lect_6;

public class BubbleSort {
  static void swap(int[] arr ,int i,int j) {
	  int temp = arr[i];
	  arr[i] = arr[j];
	  arr[j] = temp;
  }
  static void bubbleSort(int[] input) {
	  for(int unSortedIndex=input.length-1;unSortedIndex>0;unSortedIndex--) {
			for(int i=0;i<unSortedIndex;i++) {
				if(input[i]>input[i+1]) {
					swap(input,i,i+1);
				}
			}
  }
  }
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1,0};
		bubbleSort(arr);
		for(int j=0;j<arr.length;j++) {
			System.out.println(arr[j]);
		}
		
	}
		

}
