import java.util.Scanner;

public class ToggleNumTriangle {
public static void main(String[] args) {
	//Here boolean k is used for toggling
	boolean k;
	for(int i=1;i<=5;i++) {
		k=true;
		for(int j=1;j<=9;j++) {
			if(j>=6-i && j<=4+i && k) {
				if(j==6-i || j==4+i) {
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
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
