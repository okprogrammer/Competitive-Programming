import java.util.Scanner;
public class TraingleNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner num = new Scanner(System.in);
        System.out.println("Enter the Number");
        int N = num.nextInt();
        int r=1,s,in,de,k;
        while(r<=N){
            s=1;
            while(s<=N-r){
                System.out.print(" ");
                s=s+1;
            }
            in=1;
            k=r;
            while(in<=r){
                System.out.print(k);
                in = in+1;
                k=k+1;
            }
            de=1;
            k=k-2;
            while(de<r){
                System.out.print(k);
                k=k-1;
                de = de+1;
            }
            System.out.println("");
            r=r+1;
        }


	}

}
