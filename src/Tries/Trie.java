package Tries;

import java.util.ArrayList;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode[] children;
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode('\0');
	}

	public void add(String word) {
		add(root, word);
	}

	private void add(TrieNode root, String word) {

		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));

	}

	private boolean search(TrieNode root, String word) {

		if (word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return false;
		} else {
			return search(child, word.substring(1));
		}
	}

	public boolean search(String word) {
		return search(root, word);
	}

	public void delete(String word) {
		delete(root, word);
	}

	private void delete(TrieNode root, String word) {

		if (word.length() == 0) {
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return;
		}
		delete(child, word.substring(1));
		// we can delete child node only if it non-terminating and it's number of
		// children are zero

		if (!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}
		/*
		 * if(!child.isTerminating) { int numChild = 0; for (int i = 0; i < 26; i++) {
		 * if(root.children[i]!=null) { numChild++; } } if(numChild == 0) {
		 * root.children[childIndex] = null; child = null; } }
		 */
	}

	public boolean patternMatching(ArrayList<String> input, String pattern) {
		if (pattern.length() == 0) {
			return false;
		}
		for (int i = 0; i < input.size(); i++) {
			String word = input.get(i);
			for (int j = 0; j < word.length(); j++) {
				add(word.substring(j));
			}
		}

		return search(pattern);

	}

	public void autoComplete(ArrayList<String> input, String word) {

		for (int i = 0; i < input.size(); i++) {
			add(input.get(i));
		}

	}
	
	public void printCombinations(String word) {
		printCombinations(root,word);
	}

	private void printCombinations(TrieNode root, String word) {
	
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return;
		}else {
			
		}
	}

}
