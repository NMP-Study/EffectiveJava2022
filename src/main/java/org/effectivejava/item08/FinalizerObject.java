package org.effectivejava.item08;

public class FinalizerObject {
	@Override
	protected void finalize() {
		System.out.println("Start Finalized");

		if (true) {
			// finalize가 수행 중 예외가 발생해도 무시되며, 이후 작업은 수행되지 않는다.
			throw new RuntimeException();
		}

		System.out.println("Done finalized");
	}
}
