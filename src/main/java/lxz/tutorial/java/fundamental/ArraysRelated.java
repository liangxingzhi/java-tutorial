package lxz.tutorial.java.fundamental;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.springframework.util.Assert;

public class ArraysRelated {
	private void copy() {
		int[] a = {1,2,3};
		int[] c = Arrays.copyOf(a, a.length);
		Assert.isTrue(a != c, "a 和 c 必须不同");
	}
	
	public static void main(String[] args) {
		ArraysRelated ar = new ArraysRelated();
		ar.copy();
		int[] a = new int[4];
		int[] b = new int[5];
		Integer[] c = new Integer[6];
		Long[] d = new Long[7];
		System.out.println(a.getClass());
		System.out.println(b.getClass());
		System.out.println(c.getClass());
		System.out.println(d.getClass());
		System.out.println(a.getClass() == b.getClass());
		for(Field m: a.getClass().getDeclaredFields()) {
			System.out.println(m);
		}
	}
}
