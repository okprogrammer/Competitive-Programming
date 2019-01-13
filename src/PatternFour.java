
import java.util.Scanner;
public class PatternFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'E',f;
		//Creating a scanner oject s for taking input
		int N = 5;
         for(int i=1;i<=N;i++) {
        	 f=c;
        	 for(int j=1;j<=N;j++) {
        		 if(j>=1 && j<=i) {
        			 System.out.print(f);
        			 ++f;
        		 }
        		 else {
        			 System.out.print(" ");
        		 }
        	 }
        	 System.out.println("");
        	 --c;
         }


	}

}
