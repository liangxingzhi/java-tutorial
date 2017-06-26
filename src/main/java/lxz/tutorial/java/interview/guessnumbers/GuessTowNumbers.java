package lxz.tutorial.java.interview.guessnumbers;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * 1-20 之间2个数，两个数之和告诉A，两个数乘积告诉B，A说不知道2个数是多少，B说也不知道 B说完后A说他知道了，B说他也知道了 <br>
 * 解析这个题目： <br>
 * 1 根据A的回答，这2个数的和有多种分解方式 <br>
 * 2 根据B的回答，这2个数的积也有多种分解方式，并且根据每种分解方式取得的和再分解，也有超过2个有多种分解方式 <br>
 * 3 根据A最后的回答，这2个数的积只有1组积有多种分解方式，其余的都是只有一种分解方式的 <br>
 * 
 * 
 * 2,3, 1+4, 2+3
 * 
 * A = x + y B = x * y
 * 
 * 大循环所有的 x ， y，1-20之间2个数的组合
 * 
 * [2, 3] [2, 4] [9, 20] [12, 20] [15, 16]
 * 
 * @author admin
 *
 */
public class GuessTowNumbers {

	private static final int MIN = 1;
	private static final int MAX = 10000;

	public static Set<Pair> getAllPairSet() {
		Set<Pair> set = new HashSet<>();
		for (int i = MIN; i <= MAX; i++) {
			for (int j = MIN; j <= MAX; j++) {
				if (i != j) {
					set.add(new Pair(i, j));
				}
			}
		}
		return set;
	}


	public static void main(String[] args) {
		Set<Pair> pairSet = getAllPairSet();
		filterNonDuplicateSum(pairSet);
		filterNonDuplicateMultiply(pairSet);
		HashMap<Integer, Set<Pair>> map = new HashMap<>(pairSet.size());
		for (Pair p : pairSet) {
			if(map.get(p.sum()) == null) {
				map.put(p.sum(), new HashSet<Pair>());
			}
			map.get(p.sum()).add(p);
		}
		
		for(Set<Pair> s : map.values()) {
			if(s.size() == 1) {
				for(Pair pi: s) {
					System.out.println(pi);
				}
			}
		}
		
//		 print(pairSet);
	}

	private static void filterNonDuplicateSum(Set<Pair> pairSet) {
		Set<Pair> toRemoveSet = new HashSet<>();
		HashMap<Integer, Set<Pair>> map = new HashMap<>(pairSet.size());
		for (Pair p : pairSet) {
			if(map.get(p.sum()) == null) {
				map.put(p.sum(), new HashSet<Pair>());
			}
			map.get(p.sum()).add(p);
		}
		
		for(Set<Pair> s : map.values()) {
			if(s.size() == 1) {
				toRemoveSet.addAll(s);
			}
		}
		pairSet.removeAll(toRemoveSet);
	}

	private static void filterNonDuplicateMultiply(Set<Pair> pairSet) {
		Set<Pair> toRemoveSet = new HashSet<>();
		HashMap<Integer, Set<Pair>> map = new HashMap<>(pairSet.size());
		for (Pair p : pairSet) {
			if(map.get(p.multiply()) == null) {
				map.put(p.multiply(), new HashSet<Pair>());
			}
			map.get(p.multiply()).add(p);
		}
		
		for(Set<Pair> s : map.values()) {
			if(s.size() == 1) {
				toRemoveSet.addAll(s);
			}
		}
		
		pairSet.removeAll(toRemoveSet);
	}

	public static void print(Set<Pair> set) {
		int i = 0;
		for (Pair p : set) {
			System.out.println((i++) + p.toString());
		}
	}

}
