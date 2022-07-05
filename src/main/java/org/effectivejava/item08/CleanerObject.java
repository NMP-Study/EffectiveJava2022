package org.effectivejava.item08;

public class CleanerObject {
	public static class State implements Runnable {
		public void run() {
			System.out.println("Do cleaning action");
		}
	}
}
