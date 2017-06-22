package lxz.tutorial.java.jvm.gc;

public class TenuringThreshold {

	public static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		testTenuringThreshold2();
	}

	/**
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold() {
		byte[] allocation1 = new byte[_1MB / 8];
		byte[] allocation2 = new byte[_1MB * 4];
		byte[] allocation3 = new byte[_1MB * 4];
		allocation3 = null;
		allocation3 = new byte[_1MB * 4];
	}

	/**
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold2() {
		byte[] allocation1 = new byte[_1MB / 4];
		byte[] allocation2 = new byte[_1MB / 4];
		byte[] allocation3 = new byte[_1MB * 4];
		byte[] allocation4 = new byte[_1MB * 4];
		allocation4 = null;
		allocation4 = new byte[_1MB * 4];
	}
}
