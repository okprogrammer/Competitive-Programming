package lect_4;
import java.util.Scanner;
import java.lang.Math;
public class TrailingZero {
	static void findFactorialTrailZero(int N) {
		int i = 1;
	      int sumFive = 0,sumTwo=0;
	      
	      while(i<=Math.sqrt(N)){
	        if(N/(Math.pow(5,i))!=0){
	          sumFive = sumFive+N/(int)Math.pow(5,i); 
	        }
	        if(N/(Math.pow(2,i))!=0){
	          sumTwo = sumTwo+N/(int)Math.pow(2,i);
	        }
	        i=i+1;
	      }
	      if(sumFive!=0 && sumTwo!=0){
	        if(sumFive>=sumTwo){
	          System.out.println(sumTwo);
	        }
	        else{
	          System.out.println(sumFive);
	        }
	      }
	}
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
	      int N = s.nextInt();
	      findFactorialTrailZero(N);

	}

}
