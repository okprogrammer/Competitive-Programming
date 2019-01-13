package lect_4;
import java.util.Scanner;
public class BooleanDecimal {
	static void convertBoolToDec(int N) {
		int c;
        char ch;
        String s = Integer.toString(N);
        int len = s.length();
        //System.out.print(len);
        int sum=0;
        for(int j=1;j<=len;j++){
            ch = s.charAt(len-j);
            //System.out.print(ch);
            c=Character.getNumericValue(ch);
            //System.out.println("");
            //System.out.print(c);
            sum=sum+c*(int)(Math.pow(2,j-1));
        }
        System.out.println(sum);

	}
	public static void main(String[] args) {
		// Write your code here
      Scanner t = new Scanner(System.in);
        int N = t.nextInt();
        convertBoolToDec(N);
        
}
}
