package lect_12;

public class StairCase {
    static int stairCase(int n) {
    	if(n==1) {
    		return 1;
    	}
    	if(n==2) {
    		return 2;
    	}
    	if(n==3) {
    		return 4;
    	}
    	return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stairCase(7*));

	}

}
