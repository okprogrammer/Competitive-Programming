package Tries;

import java.util.ArrayList;

public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
        /*t.add("news");
        t.add("this");
        t.add("new");
        //t.delete("new");
        System.out.println(t.search("new"));*/
        ArrayList<String> input = new ArrayList<>();
        //abc def ghi cba
        input.add("abc");
        input.add("def");
        input.add("ghi");
        input.add("cba");
        System.out.println(t.patternMatching(input, "de"));
	}

}
