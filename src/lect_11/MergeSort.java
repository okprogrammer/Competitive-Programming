package lect_11;

public class MergeSort {
	
	static void mergeSort(int[]input) {
		
		if(input.length==1) {
			return;
		}
		//create left array
		int[] leftArray = new int[input.length/2];
		for(int i=0;i<leftArray.length;i++) {
			leftArray[i]=input[i];
		}
		//create right array
		int[] rightArray = new int[input.length-leftArray.length];
		for(int i=0;i<rightArray.length;i++) {
			rightArray[i]=input[i+leftArray.length];
		}
		//create right array
		mergeSort(leftArray);
		//create left array
		mergeSort(rightArray);
		//merge left and right array
		merge(leftArray,rightArray,input);
	}
	
	static void merge(int[] input1,int[] input2,int[] result) {
		int i=0,j=0,k=0;
			while(i<input1.length && j<input2.length) {
				if(input1[i]<input2[j]) {
					result[k]=input1[i];
					i++;
				}
				else {
					result[k] = input2[j];
					j++;
				}
				k++;
				
			}
		while(i<input1.length) {
			result[k++]=input1[i++];
			
		}
		while(j<input2.length) {
			result[k++]=input2[j++];
		}
		
	}

	public static void main(String[] args) {
   
	int[] input = {5,11,2,9,7,8,5,6};
      mergeSort(input);
      for(int i=0;i<input.length;i++) {
    	  System.out.print(input[i]+" ");
      }
	}

}
