package lect_8;

public class Roatation {
	static int rotationCheck(int[] input) {
		int nextCheck = input[0];
		int count = 0;
		for(int i=0;i<input.length;i++) {
			if(input[i]>=nextCheck) {
				nextCheck = input[i];
				count++;
			}
			else {
				break;
			}
		}
		return count;
	}
public static void main(String[] args) {
	int [] input = {4,5,1,2,3};
	System.out.println(rotationCheck(input));
}
}
   