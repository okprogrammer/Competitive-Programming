package lect_4;
import java.util.Scanner;
public class ReverseNumber {
	static void reverseNumber(int N) {
		int rem,k=0;
	    int digit = 1;
	    while(N!=0){
	        rem = N%10;
	        k=k+1;
	        if(k==digit && rem==0){
	            System.out.print("");
	            digit++;
	        }
	        else{
	            System.out.print(rem);
	        }
	        N=N/10;
	    }
	    if(digit==k+1){
	        System.out.println(0);
	    }
		
	}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
    int N = s.nextInt();
    reverseNumber(N);
    
}
}
