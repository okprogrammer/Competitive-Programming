import java.util.Scanner;
public class StarZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      int N = s.nextInt();
      for(int i=1;i<=N;i++) {
    	  for(int j=1;j<=2*N+1;j++) {
    		  if(j==i || j==N+1 || j==(2*N+2)-i) {
    			  System.out.print("*");
    		  }
    		  else {
    			  System.out.print(0);
    		  }
    	  }
    	  System.out.println("");
      }
	}

}
