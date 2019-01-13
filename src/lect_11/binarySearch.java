package lect_11;

public class binarySearch {
	
static int BinarySearch(int[] input,int element,int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(input[mid]>element) {
			return BinarySearch(input,element,start,mid-1);
		}
		else if(input[mid]<element) {
			return BinarySearch(input,element,mid+1,end);
		}
		else {
			return mid;
		}
	}
    
	static int BinarySearch(int[] input,int element) {
		return BinarySearch(input,element,0,input.length);
	}

	public static void main(String[] args) {
		int[] input = {1,2,5,8,9,10,11,26,56};
		System.out.println(BinarySearch(input,56));

	}

}
