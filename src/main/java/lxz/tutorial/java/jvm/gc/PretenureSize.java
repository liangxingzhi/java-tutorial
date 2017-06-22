package lxz.tutorial.java.jvm.gc;

public class PretenureSize {
	
	public static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) {
		testPretenureSizeThreshold();
	}
	
	/**
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[_1MB * 4];
	}
}
