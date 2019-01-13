import java.util.Scanner;
public class PaddleNum {

	public static void main(String[] args) {
		// Creating a scanner object s
		Scanner inp = new Scanner(System.in);
		//assigning the value in the N
		int N = inp.nextInt();
		int k,in,s;
      for(int i=1;i<=N;i++) {
    	  k=1;
    	  in=1;
    	  while(in<=N+1-i) {
    		  System.out.print(k);
    		  k=k+1;
    		  in = in+1;
    	  }
    	  s=1;
    	  while(s<i-1) {
    		  System.out.print(" ");
    		  s=s+1;
    	  }
    	  System.out.println("");
      }
	}

}
