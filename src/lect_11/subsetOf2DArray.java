package lect_11;

public class subsetOf2DArray {
	
	static int[][] subSet(int[] arr,int index){
		
		if(arr.length==index) {
			int[][]ans = new int[1][0];
			return ans;
		}
		
		int[][] smallAns = subSet(arr,index+1);
		//every time double the result array return array
		int[][] result = new int[smallAns.length*2][];
		
		for(int i=0;i<smallAns.length;i++) {
			result[i] = new int [smallAns[i].length];
			/*for(int j=0;j<result[i].length;j++) {
				result[i][j] = smallAns[i][j];
			}*/
			 result[i] =smallAns[i];
		}
		for(int i=0;i<smallAns.length;i++) {
			result[i+smallAns.length] = new int[smallAns[i].length+1];
			result[i+smallAns.length][0] = arr[index]; 
			for(int j=1;j<result[i+smallAns.length].length;j++) {
				result[i+smallAns.length][j] = smallAns[i][j-1];
			}
			
		}
		return result;
	}
public static void main(String[] args) {
	int[]arr = {1,2,3};
	int[][] result = subSet(arr,0);
	for(int i=0;i<result.length;i++) {
		for(int j=0;j<result[i].length;j++) {
			System.out.print(result[i][j]+" ");
		}
		System.out.println("");
	}
	
}
}
