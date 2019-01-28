package lxz.tutorial.java.regex;

/**
 * 0020 is space, 0008 is backspace
 * @author ezliagu
 *
 */
public class AnsiTrim {
	public static void main(String[] args) {
		String s = "C \bont";
		String ss = "";
		for (byte b : ss.getBytes()) {
			System.out.print(Integer.toHexString(b) + ":" + (char) b);
		}
		System.out.println();
		
		System.out.println(s.replaceAll("\u0020\u0008", ""));
	}
}
