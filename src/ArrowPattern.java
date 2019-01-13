import java.util.Scanner;
public class ArrowPattern {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int i=1,j,s;
        int k=1;
        boolean t;
        while(i<=N){
            s=1;
            while(s<=k-1){
                System.out.print(" ");
                s=s+1;
            }
            j=1;
            t=true;
            while(j<=2*k-1){
                if(t){
                    System.out.print("*");
                    t = false;
                }
                else{
                    System.out.print(" ");
                    t=true;
                }
                j=j+1;

            }
            //System.out.print(N/2+1);
            if(i<(N/2)+1){
                k=k+1;
            }
            else{
                k=k-1;
            }

            System.out.println("");
            i=i+1;
        }

	}

}
