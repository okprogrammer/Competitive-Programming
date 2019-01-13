package Practice;

public class array1 {
	
	static int[] arrange(int n){
		int[] arr = new int[n];
		int len = arr.length;
		boolean temp = true;
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			if(temp) {
				arr[j] = i+1;
				temp = false;
				j++;
			}else {
				arr[--len] = i+1;
				temp = true;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = arrange(9);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]+" ");
		}
	}

}
