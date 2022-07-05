package org.effectivejava.item08;

import org.junit.jupiter.api.Test;

public class FinalizerTest {
	@Test
	public void finalizeTest() {
		System.out.println("FinalizerObject 생성");
		FinalizerObject object = new FinalizerObject();

		// 객체 참조 제거
		object = null;

		// finalizerObject 인스턴스의 finalize()가 호출될지는 신도 장담 못한다.
		// 심지어 System.gc() 을 호출하더라도, gc가 돌지 안돌지는 전적으로 VM 판단이다.
		System.out.println("Request gc");
		System.gc();
	}
}
