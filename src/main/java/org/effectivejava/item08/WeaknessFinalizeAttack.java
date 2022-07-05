package org.effectivejava.item08;

public class WeaknessFinalizeAttack {
	private final int positiveNum;

	public WeaknessFinalizeAttack(int positiveNum) {
		if (positiveNum <= 0) {
			throw new IllegalArgumentException("positiveNum은 양수여야 합니다.");
		}

		this.positiveNum = positiveNum;
	}

	// finalize attack을 방어하려면 finalize()를 final로 선언하라
	// @Override
	// protected final void finalize() throws Throwable {
	// 	super.finalize();
	// }
}
