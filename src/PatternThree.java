import java.util.Scanner;

public class PatternThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
         for(int i=1;i<=N;i++) {
        	 for(int j=1;j<=N;j++) {
        		 if(j>=1 && j<=N+1-i) {
        			 if(i%2==0) {
        				 System.out.print("0");
        			 }
        			 else {
        				 System.out.print("1");
        			 }
        			
        		 }
        		 else {
        			 System.out.print(" ");
        		 }
        	 }
        	 System.out.println("");
         }

	}

}
