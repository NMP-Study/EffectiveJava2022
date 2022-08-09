package org.effectivejava.item17;

import java.util.Objects;

public final class Complex {
	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() {
		return re;
	}

	public double ImaginaryPart() {
		return im;
	}

	// 1. 동사(add) 가 아닌, 전치사(plus) 사용하여, 이 메서드가 객체의 값을 변환하지 않음을 강조
	// 2. 객체 자신을 수정하지 않고, 새로운 Complex 인스턴스를 만들어 반환
	public Complex plus(Complex o) {
		return new Complex(re + o.re, im + o.im);
	}

	public Complex minus(Complex o) {
		return new Complex(re - o.re, im - o.im);
	}

	public Complex times(Complex o) {
		return new Complex(re * o.re - im * o.im, re * o.im + im * o.re);

	}

	public Complex dividedBy(Complex o) {
		double tmp = o.re * o.re + o.im + o.im;
		return new Complex((re * o.re + im * o.im) / tmp, (im * o.re - re * o.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Complex complex = (Complex)o;
		return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(re, im);
	}

	@Override
	public String toString() {
		return String.format("(%f + %fi)", re, im);
	}
}
