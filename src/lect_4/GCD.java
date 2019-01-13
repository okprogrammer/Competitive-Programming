package lect_4;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
public class GCD {
  static void findGCD(int first,int second){
	  while(first!=second) {
	    	 if(first>second) {
	    		 first = first-second;
	    		 second = second;
	    	 }
	    	 else {
	    		 first =first;
	    		 second = second-first;
	    	 }
	     }
	     System.out.println("GCD of two numbers:");
	     System.out.println(first);
		} 

	public static void main(String[] args) {
	// creating a scanner object s 
     Scanner s = new Scanner(System.in);
     //taking input first no.  and assigning in the first
     int first = s.nextInt();
   //taking input first no. and assigning in the first
     int second = s.nextInt();
     findGCD(first,second);
     

}
}
