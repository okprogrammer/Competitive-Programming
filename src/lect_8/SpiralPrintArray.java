package lect_8;

public class SpiralPrintArray {
 static void spiralPrint(int[][] input) {
	 int count=0;
	 int cs=0;
	 int ce = input[0].length-1;
	 int rs = 0;
	 int re = input.length-1;
	 int m = re,n=ce;
	 while(count<(m+1)*(n+1)) {
		 int t1 = cs;
		 while(t1<=ce) {
			 System.out.print(input[rs][t1]+" ");
			 t1++;
			 count++;
		 }
		 rs = rs+1;
		 int t2 = rs;
		 while(t2<=re) {
			 System.out.print(input[t2][ce]+" ");
			 t2++;
			 count++;
		 }
		 ce = ce-1;
		 int t3 = ce;
		 while(t3>=cs) {
			 System.out.print(input[re][t3]+" ");
			 t3--;
			 count++;
		 }
		 re = re-1;
		 int t4 = re;
		 while(t4>=rs) {
			 System.out.print(input[t4][cs]+" ");
			 t4--;
			 count++;
		 }
		 cs = cs+1;
	 }
	 
 }
	public static void main(String[] args) {
		int[][] input = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
		spiralPrint(input);
       
	}

}
