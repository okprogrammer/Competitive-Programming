package DP;

public class EditDistance {
	
	static int editDistance(String input1,String input2) {
		if(input1.length()==0) {
			return input2.length();
		}
		
		if(input2.length()==0) {
			return input1.length();
		}
		
		if(input1.charAt(0)==input2.charAt(0)) {
			return editDistance(input1.substring(1),input2.substring(1));
		}else {
			//insert 
			int op1 = editDistance(input1,input2.substring(1));
			//delete
			int op2 = editDistance(input1.substring(1),input2);
			//replace
			int op3 = editDistance(input1.substring(1),input2.substring(1));
			return 1+Math.min(op1, Math.min(op2, op3));
		}
	}
	
	static int editDistanceM(String input1,String input2,int[][] storage) {
		int i = input1.length();
		int j = input2.length();
		if(i == 0) {
			storage[i][j] = j;
			return storage[i][j];
		}
		if(j == 0) {
			storage[i][j] = i;
			return storage[i][j];
		}
		if(storage[i][j]>0) {
			return storage[i][j];
		}
		if(input1.charAt(0)==input2.charAt(0)) {
			storage[i][j] = editDistanceM(input1.substring(1),input2.substring(1),storage); 
			return storage[i][j];
		}else {
			int op1 = editDistanceM(input1, input2.substring(1), storage);
			int op2 = editDistanceM(input1.substring(1), input2, storage);
			int op3 = editDistanceM(input1.substring(1), input2.substring(1), storage);
			storage[i][j] = 1+Math.min(op1, Math.min(op2, op3));
		}
		return storage[i][j];
	}
	
	static int editDistanceDP(String input1,String input2) {
		int i = input1.length();
		int j = input2.length();
		int[][] storage = new int[i+1][j+1];
		for(int x=0;x<=i;x++) {
			for(int y=0;y<=j;y++) {
				if(x==0) {
					storage[x][y] = y;
				}else if(y==0) {
					storage[x][y] = x;
				}else if(input1.charAt(x-1)==input2.charAt(y-1)) {
					storage[x][y] = storage[x-1][y-1];
				}else {
					storage[x][y] = 1+Math.min(storage[x-1][y], Math.min(storage[x-1][y-1], storage[x][y-1]));
				}
			}
		}
		return storage[i][j];
	}
	
	public static void main(String[] args) {
		System.out.println(editDistance("abcdef","azced"));
		int[][] storage = new int[7][6];
		System.out.println(editDistanceM("abcdef","azced",storage));
		System.out.println(editDistanceDP("abcdef","azced"));
	}

}
