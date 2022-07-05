package org.effectivejava.item08;

import java.lang.ref.Cleaner;

import org.junit.jupiter.api.Test;

public class CleanerTest {
	@Test
	public void cleanerTest() {
		System.out.println("CleanerObject 생성");
		CleanerObject object = new CleanerObject();

		Cleaner cleaner = Cleaner.create();
		cleaner.register(object, new CleanerObject.State());

		// 객체 참조 제거
		object = null;

		// gc가 동작할 때 cleaner가 수행된다
		System.out.println("Request gc");
		System.gc();
	}

	@Test
	public void cleanerTest2() {
		System.out.println("CleanerObject 생성");
		CleanerObject cleanerObject = new CleanerObject();

		Cleaner cleaner = Cleaner.create();
		Cleaner.Cleanable cleanable = cleaner.register(cleanerObject, new CleanerObject.State());

		// 객체 참조 제거
		cleanerObject = null;

		// 직접 clean을 수행할 수 있다.
		System.out.println("Call clean");
		cleanable.clean();
	}
}
