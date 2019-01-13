
public class PatternFive {

	public static void main(String[] args) {
		//declaring variable for row,increment,decrement and spaces
		int r,in,de,s,k;
		r=1;
    while(r<=6) {
    	s=1;
    	k=r-1;
    	de=1;
    	in=1;
    	//This is for printing spaces
    	while(s<=6-r) {
    		System.out.print(" ");
    		s=s+1;
    	}
    	//This while loop for decrementing
    	while(de<=r) {
    		System.out.print(k);
    		k=k-1;
    		de=de+1;
    	}
    	k=k+1;
    	//This while loop for incrementing the value
    	while(in<=r-1) {
    		k=k+1;
    		System.out.print(k);
    		in=in+1;
    	}
    	System.out.println("");
    	r=r+1;
    }
	}

}
