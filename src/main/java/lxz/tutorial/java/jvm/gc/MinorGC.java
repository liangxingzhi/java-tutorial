package lxz.tutorial.java.jvm.gc;

public class MinorGC {
	
	public static final int _1MB = 1024 * 1024;
	public static void main(String[] args) {
		triggerMinorGC();
		while(true){
			
		}
	}
	
	/**
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void triggerMinorGC() {
		byte[] allocation1 = new byte[2 * _1MB];
		byte[] allocation2 = new byte[2 * _1MB];
		byte[] allocation3 = new byte[2 * _1MB];
		byte[] allocation4 = new byte[2 * _1MB]; // trigger Minor GC
		byte[] allocation5 = new byte[2 * _1MB];
	}
	
}
