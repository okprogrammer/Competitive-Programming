package stringMatching;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarpAlgorithm {
	
	private static long patHash;//pattern hash value
	private static int M;//pattern length
	private static long Q;//modulus
	private static int R;//radix
	private static long RM;//R^(M-1)%Q
	
	//this will generate the very big prime number
	 private static long longRandomPrime() {
	        BigInteger prime = BigInteger.probablePrime(31, new Random());
	        return prime.longValue();
	    }
	
	 //constructor will calculate the pattern string hashcode
	public RabinKarpAlgorithm(String pat) {
		M = pat.length();
		R=256;
		Q = longRandomPrime();// a large value but avoid overflow
		RM = 1;
		for(int i=1;i<=M-1;i++) {
			RM = (R*RM)%Q;
			patHash = hash(pat,M);
		}
	}
	

//search will check the pattern hash key is equal to the txt hash key or not	
	public static int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash) {
			return 0;
		}
		for(int i=M;i<N;i++) {
			txtHash = (txtHash+Q-RM*txt.charAt(i-M)%Q)%Q;
			txtHash = (txtHash*R+txt.charAt(i))%Q;
			if(patHash==txtHash) {
				return i-M+1;
			}
		}
		return N;
	}
     //we are founding the hash code for first m character 
	private static long hash(String txt, int m2) {
		long h=0;
		for(int j=0;j<M;j++) {
			h = (R*h+txt.charAt(j))%Q;
		}
		return h;
	}

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS"; 
        String pat = "FOR"; 
		RabinKarpAlgorithm p = new RabinKarpAlgorithm(pat);
		
        System.out.println(search(txt)); 
		

	}

}
