package hasmap;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapPractise {

	static void intersection(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			int value = arr1[i];
			if (map.containsKey(value)) {
				map.put(arr1[i], map.get(value) + 1);
			} else {
				map.put(arr1[i], 1);
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
				map.put(arr2[i], map.get(arr2[i]) - 1);
				System.out.println(arr2[i]);
			}
		}

	}

	static char getMaxFrequCharacter(String input) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		int maxFreq = 0;
		char ch = 0;
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() > maxFreq) {
				maxFreq = e.getValue();
				ch = e.getKey();
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		//System.out.println(getMaxFrequCharacter("sjflaskdjslfkjdlsjfkjd"));
		int[] arr1 = {2, 6, 1, 2};
		int[] arr2 = {1, 2, 3, 4, 2};
		intersection(arr1,arr2);

	}

}
