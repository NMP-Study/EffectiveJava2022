package org.effectivejava.item08;

import org.junit.jupiter.api.Test;

public class AutoCloseableTest {
	@Test
	public void autoCloseableTest() {
		System.out.println("AutoCloseableObject 생성");
		AutoCloseableObject object = new AutoCloseableObject();

		object.close();
	}

	@Test
	public void autoCloseableTest2() {
		try (AutoCloseableObject object = new AutoCloseableObject()) {
			System.out.println("AutoCloseableObject 생성");
		}
	}
}
