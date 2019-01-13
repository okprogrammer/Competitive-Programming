package lect_14;

import java.util.Scanner;

 class Node<T>{
	T data;
	Node<T> next;
	Node(T d){
		data =d;
		next=null;
	}
}
public class LinkedList {
	//delete Node recursively
	static Node<Integer> deleteIthNodeRec(Node<Integer> head,Node<Integer> temp, int i,int j){
	      if(temp==null){
	        return head;
	      }
	      if(i==0){
	        head = head.next;
	        return head;
	      }
	      if(j==i-1){
	        if(temp.next!=null){
	        temp.next = temp.next.next;
	        return head;
	        }
	      }
	      return deleteIthNodeRec(head,temp.next,i,j+1);
	      
	    }
	//code for inserting recursively
	static Node<Integer> insertR(Node<Integer>head,Node<Integer> temp,int data,int pos,int i){
	      if(temp==null){
	        return head;
	      }
	     if(pos==0){
	       Node<Integer> node = new Node<>(data);
	       node.next = head;
	       head = node;
	       return head;
	     }
	      if(i==pos-1){
	        Node<Integer> node = new Node<>(data);
	        node.next = temp.next;
	        temp.next = node;
	        return head;
	      }
	      return insertR(head,temp.next,data,pos,i+1);
	    }
	static Node<Integer> changelist(Node<Integer> head) {
		// Write your code here
      Node<Integer> current = head,temp1 = null,temp2 = null;
      Node<Integer> prev=null;
      
      while(current.next!=null){
        temp2 = current.next;
        temp1 = current.next;
        while(temp2.next!=null){
          if(temp2.next.next==null){
            prev = temp2;
          }
          temp2 = temp2.next;
        }
        prev.next = null;
        temp2.next = temp1;
        current.next = temp2;
        current = current.next;
      }
      return head;

	}
	 static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
	      Node<Integer> temp = head,prev=null;
	      while(temp!=null){
	        int i=0,j=0;
	        while(i<M && temp!=null){
	          prev = temp;
	          temp = temp.next;
	          i++;
	        }
	        while(j<N && temp!=null){
	        	if(temp.next==null) {
	        		prev.next=null;
	        	}
	          if(temp.next!=null) {
	        	  if(temp.next.next==null) {
		        	  temp.data = temp.next.data;
		        	  temp.next = temp.next.next;
		          }
	          temp.data = temp.next.data;	  
	          temp.next = temp.next.next;
	          }
	          
            j++;
	        }
	      }
	   return head;
		}

	static Node<Integer> sortEvenOdd(Node<Integer> head) {
	      
	      Node<Integer> evenHead=null,evenTail = null;
	      Node<Integer> oddHead=null,oddTail = null;
	     
	      while(head!=null){
	        if(head.data%2!=0){
	          if(oddHead==null && oddTail==null){
	            oddHead = head;
	            oddTail = head; 
	          }
	          else{
	            oddTail.next = head;
	            oddTail = head;
	          }
	        }
	        else{
	          if(evenHead==null && evenTail==null){
	            evenHead=head;
	            evenTail = head;
	          }
	          else{
	            evenTail.next = head;
	            evenTail = head;
	          }
	        }
	        head = head.next;
	      }
	      if(evenTail!=null){
	        evenTail.next = null;
	      }
	      
	      if(oddTail!=null){
	        oddTail.next = null;
	      }
	      if(oddHead!=null){
	         oddTail.next = evenHead;
	        return oddHead;
	      }
	     return evenHead;

		}

	static Node<Integer> prepareLinkedList() {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
		while(data!=-1) {
			Node<Integer> temp = new Node<Integer>(data);
			if(head==null) {
				head = temp;
				tail = temp;
			}
			else {
				tail.next=temp;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	static void PrintLinkedlist(Node<Integer> head) {
		Node<Integer> temp =head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	static void PrintRecursionLinkedlist(Node<Integer> head) {
		Node<Integer> temp = head;
		if(temp==null) {
			return;
		}
			PrintRecursionLinkedlist(temp.next);
		   System.out.print(temp.data+" ");
		
	}
	 
	static Node<Integer> reverse(Node<Integer> root){
		Node<Integer> curr,prev;
		curr = root;
		prev = null;
		while(curr!=null) {
			Node<Integer> fwd = curr.next;
			curr.next = prev;
			prev = curr;
		    curr = fwd;
		}
		
		return prev;
	}

	public static void main(String[] args) {
	
		 Node<Integer> head = prepareLinkedList(); 
		 /*PrintLinkedlist(head);
		 System.out.println();
		 PrintRecursionLinkedlist(head);
		 head = skipMdeleteN(head,2,3);*/
		 //head = changelist(head);
		 //head = insertR(head,head,300,3,0);
		 PrintLinkedlist(head);
		 Node<Integer>root = reverse(head);
		 System.out.println();
		 PrintLinkedlist(root);

	}

}
