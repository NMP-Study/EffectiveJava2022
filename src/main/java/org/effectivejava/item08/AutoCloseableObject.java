package org.effectivejava.item08;

public class AutoCloseableObject implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("Do closed");
	}
}
