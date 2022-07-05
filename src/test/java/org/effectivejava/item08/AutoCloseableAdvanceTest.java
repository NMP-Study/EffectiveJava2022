package org.effectivejava.item08;

import org.junit.jupiter.api.Test;

public class AutoCloseableAdvanceTest {
	@Test
	public void autoCloseableTest() {
		System.out.println("AutoCloseableAdvanceObject 생성");
		AutoCloseableAdvanceObject object = new AutoCloseableAdvanceObject();

		object.close();
	}

	@Test
	public void autoCloseableTest2() {
		try (AutoCloseableAdvanceObject object = new AutoCloseableAdvanceObject()) {
			System.out.println("AutoCloseableAdvanceObject 생성");
		}
	}

	@Test
	public void autoCloseableTest3() {
		System.out.println("AutoCloseableAdvanceObject 생성");
		AutoCloseableAdvanceObject object = new AutoCloseableAdvanceObject();

		// 객체 참조 제거
		object = null;

		// gc가 동작할 때 cleaner가 수행된다
		System.out.println("Request gc");
		System.gc();
	}
}
