package lxz.tutorial.java.fundamental;

import java.lang.reflect.Field;

import org.springframework.util.Assert;

public class StringRelated {

	public static String valueField() throws Exception {
		Field f = String.class.getDeclaredField("value");
		f.setAccessible(true);
		char[] c1 = (char[]) f.get(new String());
		char[] c2 = (char[]) f.get(new String());
		Assert.isTrue(c1 != c2, "两个新创建的字符串内部的 char[] value 必须相同");
		return null;
	}

	public static String string() throws Exception {
		System.out.println("" == "");
		System.out.println(new String() == new String());
		return "";
	}

	public static void main(String[] args) throws Exception {
		string();
		valueField();

	}
}
