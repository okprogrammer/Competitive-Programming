package lect_12;

public class TowerOfHanoi {
	
	static void towerOfHanoi(char src,char helper,char dest,int n) {
		if(n==0) {
			return;
		}
		towerOfHanoi(src,dest,helper,n-1);
		System.out.println("put "+n+"th ring from "+src+" to "+dest);
		towerOfHanoi(helper,src,dest,n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     towerOfHanoi('A','B','C',3);
	}

}
