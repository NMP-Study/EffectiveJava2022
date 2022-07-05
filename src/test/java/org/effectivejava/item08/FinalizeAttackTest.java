package org.effectivejava.item08;

import org.junit.jupiter.api.Test;

public class FinalizeAttackTest {
	@Test
	public void finalizeAttack() throws InterruptedException {
		System.out.println("Check weaknessObject 1");
		if (FinalizeAttack.weaknessObject == null) {
			System.out.println("weaknessObject is null");
		}

		try {
			System.out.println("FinalizeAttack 생성");
			new FinalizeAttack(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Check weaknessObject 2");
		if (FinalizeAttack.weaknessObject == null) {
			System.out.println("weaknessObject is null");
		}

		// gc가 동작할 때 weaknessObject가 의도치 않은 상태로 할당된다.
		System.out.println("Request gc");
		System.gc();

		Thread.sleep(1);

		System.out.println("Check weaknessObject 3");
		if (FinalizeAttack.weaknessObject == null) {
			System.out.println("weaknessObject is null");
		}
	}

	private static class FinalizeAttack extends WeaknessFinalizeAttack {
		public static WeaknessFinalizeAttack weaknessObject;

		public FinalizeAttack(int positiveNum) {
			super(positiveNum);
		}

		@Override
		protected void finalize() {
			System.out.println("Do Finalized");
			weaknessObject = this;
		}
	}
}
