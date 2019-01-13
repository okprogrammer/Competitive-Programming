package lect_5;

import java.util.Scanner;

public class NoRepetition {

	public static int findUnique(int[] arr) {
		int search, count;
		for (int i = 0; i < arr.length; i++) {
			count = 0;
			search = arr[i];
			for (int j = 0; j < arr.length; i++) {
				if (search == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				return search;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		int t = findUnique(arr);
		System.out.println(t);
	}

}
