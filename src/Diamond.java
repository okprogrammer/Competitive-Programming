
public class Diamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=1;
		for(int i=1;i<=7;i++) {
			for(int j=1;j<=7;j++) {
				if(j>=5-k && j<=3+k)
				{
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
				
			}
			System.out.println("");
			if(i<4) {
				k=k+1;
			}
			else {
				k=k-1;
			}
		}

	}

}
