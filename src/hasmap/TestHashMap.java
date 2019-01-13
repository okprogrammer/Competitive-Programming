package hasmap;

import java.util.ArrayList;

 class MapNode<K, V> {
	K key;
	V value;
	MapNode<K, V> next;

	MapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class CustomHashMap<K, V> {

	int bucketSize;
	int noOfEntries;

	public CustomHashMap() {
		bucketSize = 10;
		noOfEntries = 0;
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
	}

	ArrayList<MapNode<K, V>> bucket = new ArrayList<>();

	void put(K key, V value) {
		int hashCode = getHashCode(key);
		int index = compress(hashCode);

		MapNode<K, V> head = bucket.get(index);
		
		
		
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		noOfEntries++;
		head = bucket.get(index);
		MapNode<K, V> node = new MapNode<>(key, value);
		node.next = head;
		bucket.set(index, node);

		
		if ((noOfEntries * (1.0) / bucketSize) > .7) {
			extendsBucket();
		}
	}

	private void extendsBucket() {
		bucketSize = 2 * bucketSize;
		noOfEntries=0;
		ArrayList<MapNode<K, V>> temp = bucket;
		bucket = new ArrayList<>();
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
		System.out.println("Map Extend from "+temp.size()+" To "+bucket.size());
		for (MapNode<K, V> head : temp) {
			while (head != null) {
				put(head.key, head.value);
				head = head.next;
			}
		}
		
	}

	private int compress(int code) {
		return code % bucketSize;
	}

	private int getHashCode(K key) {
		return Math.abs(key.hashCode());
	}

	V get(K key) {
		int hashCode = getHashCode(key);
		int index = compress(hashCode);
		MapNode<K, V> head = bucket.get(index);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	ArrayList<K> keySet() {
		ArrayList<K> list = new ArrayList<>();
		for (MapNode<K, V> head : bucket) {
			while (head != null) {
				list.add(head.key);
				head = head.next;
			}
		}
		return list;
	}
//
//	ArrayList<V> valueSet() {
//
//	}

	ArrayList<MapNode<K, V>> getEntrySet() {
		ArrayList<MapNode<K, V>> list = new ArrayList<>();
		for (MapNode<K, V> head : bucket) {
			while (head != null) {
				list.add(head);
				head = head.next;
			}
		}
		return list;
	}

}

public class TestHashMap {
	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
		//map.put("Aman",4);
		
		int i = 0;
		while(i<200){
			map.put("A_"+i, i);
			System.out.println("Put "+ "A_"+i+" "+i);
			i++;
		}
		System.out.println(map.get("Aman"));
	}
}
