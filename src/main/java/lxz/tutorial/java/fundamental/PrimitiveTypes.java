package lxz.tutorial.java.fundamental;

public class PrimitiveTypes {

	private static final String TYPE_FORMAT = "%10s";
	private static final String BYTES_FORMAT = "%10s";
	private static final String RANGE_FORMAT = "%45s";

	public static void main(String[] args) {
		newLine();
		headerLine();
		PrimitiveTypes type = new PrimitiveTypes();
		type.byteType();
		type.boolType();
		type.voidType();
		type.shortType();
		type.charType();
		type.intType();
		type.floatType();
		type.longType();
		type.doubleType();

		type.integerClass();
	}
	
	private static void newLine() {
		System.out.println("\n--------------------------------------------------------------------");
	}
	
	public static byte getBytes(long param) {
		byte bytes = 1;
		while ((param = (param >> 8) ) > 0) {
			bytes++;
		}
		return bytes;
	}

	private static void headerLine() {
		System.out.printf(TYPE_FORMAT, "TYPE");
		System.out.printf(BYTES_FORMAT, "BYTES");
		System.out.printf(RANGE_FORMAT, "RANGE");
		newLine();
	}
	public void byteType() {
		System.out.printf(TYPE_FORMAT, Byte.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Byte.MAX_VALUE));
		System.out.printf(RANGE_FORMAT, String.valueOf(Byte.MIN_VALUE) + "~" + String.valueOf(Byte.MAX_VALUE));
		newLine();
	}

	public void byteType2() {
		short s1 = 10241;
		// incompatiable types
		// s1 = s1 + 1;
		// has implicit type conversion
		s1 += 1121234124;
	}

	public void shortType() {
		System.out.printf(TYPE_FORMAT, Short.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Short.MAX_VALUE));
		System.out.printf(RANGE_FORMAT, String.valueOf(Short.MIN_VALUE) + "~" + String.valueOf(Short.MAX_VALUE));
		newLine();
	}

	public void intType() {
		System.out.printf(TYPE_FORMAT, Integer.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Integer.MAX_VALUE));
		System.out.printf(RANGE_FORMAT, String.valueOf(Integer.MIN_VALUE) + "~" + String.valueOf(Integer.MAX_VALUE));
		newLine();
	}

	public void longType() {
		System.out.printf(TYPE_FORMAT, Long.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Long.MAX_VALUE));
		System.out.printf(RANGE_FORMAT, String.valueOf(Long.MIN_VALUE) + "~" + String.valueOf(Long.MAX_VALUE));
		newLine();
	}
	
	public void floatType() {
		System.out.printf(TYPE_FORMAT, Float.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Float.floatToIntBits(Float.MAX_VALUE)));
		System.out.printf(RANGE_FORMAT, String.valueOf(Float.MIN_VALUE) + "~" + String.valueOf(Float.MAX_VALUE));
		newLine();
	}
	
	public void doubleType() {
		System.out.printf(TYPE_FORMAT, Double.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes(Double.doubleToLongBits(Double.MAX_VALUE)));
		System.out.printf(RANGE_FORMAT, String.valueOf(Double.MIN_VALUE) + "~" + String.valueOf(Double.MAX_VALUE));
		newLine();
	}
	
	public void charType() {
		System.out.printf(TYPE_FORMAT, Character.TYPE);
		System.out.printf(BYTES_FORMAT, getBytes((int)Character.MAX_VALUE));
		System.out.printf(RANGE_FORMAT, String.valueOf((int)Character.MIN_VALUE) + "~" + String.valueOf((int)Character.MAX_VALUE));
		newLine();
	}
	
	public void boolType() {
		System.out.printf(TYPE_FORMAT, Boolean.TYPE);
		System.out.printf(BYTES_FORMAT, 1);
		System.out.printf(RANGE_FORMAT, String.valueOf(Boolean.FALSE) + "~" + String.valueOf(Boolean.TRUE));
		newLine();
	}

	public void voidType() {
		System.out.printf(TYPE_FORMAT, Void.TYPE);
		System.out.printf(BYTES_FORMAT, 1);
		newLine();
	}

	public void integerClass() {
		Integer a = new Integer(3);
		Integer b = 3;                  // 将3自动装箱成Integer类型
		int c = 3;
		System.out.println(a == b);     // false 两个引用没有引用同一对象
		System.out.println(a == c);
	}
}
