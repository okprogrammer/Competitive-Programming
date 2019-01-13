
public class PatternButterFly {

	public static void main(String[] args) {
		int k=1;
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				if(j<=k || j>=10-k) {
					//This is inner condition of existing area
					//Here we are checking whether sum of rows and column is even or odd
					if((i+j)%2 == 0) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					System.out.print(" ");
				}
			}
			if(i<5) {
				k=k+1;
			}
			else {
				k=k-1;
			}
			System.out.println("");
		}

	}

}
