import java.util.Scanner;
public class PatternTwo {

	public static void main(String[] args) {
		//declaring a c variable with A
		char c = 'A';
		//Creating a scanner oject s for taking input
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
         for(int i=1;i<=N;i++) {
        	 for(int j=1;j<=N;j++) {
        		 if(j>=1 && j<=i) {
        			 System.out.print(c);
        		 }
        		 else {
        			 System.out.print(" ");
        		 }
        	 }
        	 System.out.println("");
        	 ++c;
         }

	}

}
