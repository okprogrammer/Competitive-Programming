package huffman;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;

class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
        return x.data - y.data; 
    } 
} 

public class Huffman{

	static void printCode(HuffmanNode root,String s) {
		//Base case
		if(root.left==null && root.right==null && Character.isLetter(root.c)) {
			System.out.println(root.c+" :"+s);
			return;
		}
		
		printCode(root.left,s+"0");
		printCode(root.right,s+"1");
		
	}
	static void storeCode(HashMap<Character,String> codes,HuffmanNode root,String s) {
		//Base case
		if(root.left==null && root.right==null && Character.isLetter(root.c)) {
			codes.put(root.c,s);
			return;
		}
		
		storeCode(codes,root.left,s+"0");
		storeCode(codes,root.right,s+"1");
		
	}
	
	static String decoded_String(HuffmanNode root,String s) {
		String decode = "";
		HuffmanNode curr = root;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				curr = curr.left;
			}else {
				curr = curr.right;
			}
			if(curr.left==null && curr.right==null) {
				decode = decode+curr.c;
				curr = root;
			}
		}
		return decode;
	}
	public static void main(String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e' }; 
        int[] charfreq = { 3, 5, 6, 4, 2 }; 
        int n = 5;
        
        HashMap<Character,String> codes = new HashMap<>();
        
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n,new MyComparator());
        //creating the min-heap
        for(int i=0;i<n;i++) {
        	HuffmanNode hm = new HuffmanNode();
        	hm.c = charArray[i];
        	hm.data = charfreq[i];
        	hm.left = null;
        	hm.right = null;
        	q.add(hm);
        	
        }
        HuffmanNode root = null;
        //making the tree
        while(q.size()>1) {
        	HuffmanNode x = q.peek();
        	q.poll();
        	HuffmanNode y = q.peek();
        	q.poll();
        	HuffmanNode f = new HuffmanNode();
        	f.data = x.data+y.data;
        	f.c = '-';
        	f.left = x;
        	f.right = y;
        	root = f;
        	q.add(f);
        }
        
        storeCode(codes,root,"");
        
        printCode(root, "");
        String encodedString="";
        for(Character c:charArray) {
        	encodedString = encodedString+codes.get(c);
        }
        System.out.println("This is the endcode string");
        System.out.println(encodedString);
        System.out.println("This is the decoded string!");
        System.out.println(decoded_String(root, encodedString));
	}
         
}
