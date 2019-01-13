import java.util.Scanner;
public class PaddleTwo {

	public static void main(String[] args) {
		int l;
		//for toggling condition
		boolean k;
		for(int i=1;i<=5;i++) {
			k=true;
			l=i;
			for(int j=1;j<=9;j++) {
				if(j>=6-i && j<=4+i && k) {
					System.out.print(l);
					k=false;
				}
				else {
					k=true;
					System.out.print(" ");
				}
			}
			System.out.println("");
		}

	}

}
