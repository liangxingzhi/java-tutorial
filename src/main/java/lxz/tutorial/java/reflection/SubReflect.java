package lxz.tutorial.java.reflection;

import java.lang.reflect.Field;

public class SubReflect extends SuperReflect {
	public int field4 = 7;

	public static int field5 = 9;

	private int field6 = 3;

	public static void main(String[] args) {
		SubReflect obj = new SubReflect();
		for (Field f : SubReflect.class.getDeclaredFields()) {
			System.out.println(f.getDeclaringClass().getSimpleName() + "." + f.getName());
		}
	}
}
