
public class PatternBridge {

	public static void main(String[] args) {
		
		int k;
		for(int i=1;i<=4;i++) {
			k=1;
			for(int j=1;j<=8;j++) {
				//This condition for printing numbers
				if(j<=5-i || j>=4+i) {
					System.out.print(k);
					if(j<=5-i) {
						k++;
						//This condition for decrement when j reached to at the the first end
						if(j==5-i) {
							k=k-1;
						}
					}
					else {
						k--;
					}
				}
				else {
					System.out.print("*");
				}
		}
			System.out.println("");

	}

}
}
