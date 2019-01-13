import java.util.Scanner;
public class PatternOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
         for(int i=1;i<=N;i++) {
        	 for(int j=1;j<=N;j++) {
        		 if(j>=1 && j<=N+1-i) {
        			 System.out.print("*");
        		 }
        		 else {
        			 System.out.print(" ");
        		 }
        	 }
        	 System.out.println("");
         }
	}

}
