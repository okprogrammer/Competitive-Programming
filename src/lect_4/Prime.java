package lect_4;
import java.util.Scanner;
public class Prime {
	static void check_Prime(int n) {
		int i=2;
	      boolean flag =true;
	      //int count=0;
	      while(i<n/2) {
	    	  if(n%i==0) {
	    		  System.out.println("Number is not prime");
	    		  flag=false;
	    		  break;
	    	  }
	    	  i=i+1;
	    	  //count=count+1;
	      }
	      if(flag) {
	      System.out.println("Number is prime");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the number:");
      int N = s.nextInt();
      check_Prime(N);
      
	}

}
