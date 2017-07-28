package lxz.tutorial.java.fundamental;

import java.util.HashMap;
import java.util.Hashtable;

public class MapRelated {
	public void acceptNull() {
		HashMap<String, String> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map.get(null));
		map.put(null, "aa");
		System.out.println(map.get(null));
	}

	public synchronized void  acceptNotNull() {
		Hashtable<String, String> map = new Hashtable<>();
		map.put(null, null);
		System.out.println(map.get(null));
		map.put(null, "aa");
		System.out.println(map.get(null));
	}

	public static void main(String[] args) {
		MapRelated mr = new MapRelated();
		mr.acceptNull();
		mr.acceptNotNull();
		
		synchronized ("") {
			
		}
	}
}
