package lxz.tutorial.java.fundamental;

import java.math.BigDecimal;

public class RadixRelated {

	public static void main(String[] args) {
		RadixRelated rr = new RadixRelated();
		System.out.println("radix = 2, 10     -> " + rr.toBinary(10, 2));
		System.out.println("radix = 3, 12     -> " + rr.toBinary(12, 3));
		System.out.println("radix = 2, 10.625 -> " + rr.fractionToBinary(-10.625f, 2));
	}

	private String toBinary(int dividend, int radix) {
		StringBuilder sb = new StringBuilder();
		final int divisor = radix;
		int quotient = Math.abs(dividend);
		while (quotient / divisor > 0) {
			sb.append(quotient % divisor);
			quotient /= divisor;
		}
		sb.append(quotient % divisor);
		sb.reverse();
		return sb.toString();
	}

	private String fractionToBinary(float f, int r) {
		boolean positive = f > 0 ? true : false;
		BigDecimal result = new BigDecimal(f).abs();
		final BigDecimal radix = new BigDecimal(r);
		StringBuilder sb = new StringBuilder();
		if (result.intValue() > 0) {
			sb.append(toBinary(result.intValue(), r));
			result = result.add(new BigDecimal(-result.intValue()));
		}
		if (result.compareTo(BigDecimal.ZERO) > 0) {
			sb.append(".");

			int maxTries = 23;
			while (result.compareTo(BigDecimal.ZERO) > 0 && maxTries-- > 0) {
				result = result.multiply(radix);
				sb.append(result.intValue());
				result = result.add(new BigDecimal(-result.intValue()));
			}
		}
		return positive ? sb.toString() : "-" + sb.toString();
	}
}
