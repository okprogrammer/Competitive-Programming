package lect_9;

public class recurssionPractice {
     static int search7(int[] input) {
    	 if(input.length==0) {
    		 return -1;
    	 }
    	 if(input[0]==7) {
    		 return 0;
    	 }
    	 int[] smallArray = new int[input.length-1];
    	 for(int i=0;i<smallArray.length;i++) {
    		 smallArray[i] = input[i+1];
    	 }
    	 int smallAns = search7(smallArray)+1;
    	 return smallAns;
     }
     static int searchLast7(int[] input,int Index) {
    	 if(input.length==Index) {
    		 return -1;
    	 }
    	 int smallAns = searchLast7(input,Index+1);
    	 if(smallAns ==-1) {
    		 if(input[Index]==7) {
    			 return Index;
    		 }
    	 }
    	 return smallAns;
     }
     
     static boolean search7WithIndex(int[] input,int Index) {
    	 if(input.length==Index) {
    		 return false;
    	 }
    	 if(input[Index]==7) {
    		 return true;
    	 }
    	 
    	 return search7WithIndex(input,Index+1);
     }
     static boolean isArraySorted(int[] input,int Index) {
    	 if(input.length-1==Index ||input.length==Index) {
    		 return true;
    	 }
    	 if(input[Index]>input[Index+1]) {
    		 return false;
    	 }
    	 return isArraySorted(input,Index+1);
    	 
     }
	public static void main(String[] args) {
		int[] input = {1,2,3,4,2,0,7};
		System.out.println(isArraySorted(input,0));
		System.out.println(searchLast7(input,0));
	    int ans = search7(input)-1;
	    System.out.println(ans);
	    System.out.println(search7WithIndex(input,0));
	    

	}

}
