package lect_10;

public class PrintArrayUsingRecursion {
	static void printArray(int[] input,int index) {
		if(index==input.length) {
			return;
		}
		System.out.print(input[index]+" ");
		System.out.println();
		printArray(input,index+1);
		System.out.print(input[index]+" ");
		
	}
public static void main(String[] args) {
	int[] input = {1,2,5,7,8,96,3};
	printArray(input,0);

}
}