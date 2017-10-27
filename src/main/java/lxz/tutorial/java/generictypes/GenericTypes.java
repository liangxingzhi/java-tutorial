package lxz.tutorial.java.generictypes;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		produce(numbers);

		List<Object> numbers2 = new ArrayList<>();
		numbers2.add(10);
		consume(numbers2);
	}
	public static String m1(List<String> s) {
		return null;

	}

//	 public static int m1(List<Integer> s) {
//
//	 }

	public static void produce(List<? extends Number> numbers) {
		// this list can produce, which means can get Number from this list
		Number m = numbers.get(0);
		// can't put number into this list
		// numbers.add(new Integer(10));
	}

	public static void consume(List<? super Number> numbers) {
		// this list can't product, which means can't get Number from this list
		// Number m = numbers.get(0);
		// this list can consume Integer which is subclass of Number
		numbers.add(new Integer(10));
	}

	public static void produceAndConsume(List<Integer> numbers) {
		Integer i = numbers.get(0);
		numbers.add(10);
	}
}
