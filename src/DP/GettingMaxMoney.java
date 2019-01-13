package DP;

public class GettingMaxMoney {
	
	static int getMaxMoney(int[] arr,int i,int n) {
		if(i>=n) {
			return 0;
		}
		
		int op1 = arr[i]+getMaxMoney(arr, i+2,n);
		int op2 = getMaxMoney(arr, i+1,n);
		
		return Math.max(op1, op2);
	}
	
	static int getMaxMoneyM(int[] arr,int[] storage,int i) {
		if(i>=arr.length) {
			return 0;
		}
		if(storage[i]>0) {
			return storage[i];
		}
		int op1 = arr[i]+getMaxMoneyM(arr, storage, i+2);
		int op2 = getMaxMoneyM(arr, storage, i+1);
		storage[i] = Math.max(op1, op2);
		return storage[i];
	}
	
	static int getMaxMoneyDP(int[] arr) {
		int[] storage = new int[arr.length];
		storage[0] = arr[0];
		storage[1] = Math.max(arr[1], arr[0]);
		
		for(int i=2;i<arr.length;i++) {
			storage[i] = Math.max(storage[i-1], arr[i]+storage[i-2]);
		}
		return storage[arr.length-1];
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10, 5};
		System.out.println(getMaxMoneyDP(arr));
		System.out.println(getMaxMoney(arr, 0,arr.length));
		int[] storage = new int[arr.length];
		System.out.println(getMaxMoneyM(arr, storage, 0));
	}

}
