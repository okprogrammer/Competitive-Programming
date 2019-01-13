package lect_10;

public class recursion_practice {
	static int[] allIndicesOf7(int[] input,int index)
	{
		if(input.length==index) {
			int[] arr = new int[0];
			return arr;
		}
		int[] smallAns = allIndicesOf7(input,index+1);
		if(input[index]==7) {
			int[] arr = new int[smallAns.length+1];
			arr[0]=index;
			for(int i=0;i<smallAns.length;i++) {
				arr[i+1]=smallAns[i];
			}
			return arr;
		}
		return smallAns;

	}
	public static void main(String[] args) {
    int[] input = {1,10,7,7,8,4,7,5};
    int[] newarray = allIndicesOf7(input,0);
    for(int i=0;i<newarray.length;i++) {
    	System.out.print(newarray[i]+" ");
    }
	}

}
