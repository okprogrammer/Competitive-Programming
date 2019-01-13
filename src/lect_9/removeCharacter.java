package lect_9;

public class removeCharacter {
static String removeX(String input) {
	if(input.length()==0) {
		return input;
	}
	//where x meets it insert blank
	String newStr = input.startsWith("x")? "":input.substring(0,1);
	//recursing add element after every 0th index
	return newStr+removeX(input.substring(1));
}
public static void main(String[] args) {
	System.out.println(removeX("xxfajxsjflx"));
}
}
