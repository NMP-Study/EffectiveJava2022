package org.effectivejava.item08;

import java.lang.ref.Cleaner;

public class AutoCloseableAdvanceObject implements AutoCloseable {
	private static final Cleaner cleaner = Cleaner.create();
	private final Cleaner.Cleanable cleanable;

	public AutoCloseableAdvanceObject() {
		cleanable = cleaner.register(this, () -> System.out.println("Do clean"));
	}

	@Override
	public void close() {
		cleanable.clean();
	}
}
