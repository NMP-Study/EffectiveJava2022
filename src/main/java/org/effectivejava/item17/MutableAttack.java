package org.effectivejava.item17;

import java.util.Date;

public class MutableAttack {
	public static void main(String[] args) {
		MutablePeriod mp = new MutablePeriod();
		Period period = mp.period;
		Date end = mp.end;

		end.setYear(78);
		System.out.println(period);

		end.setYear(69);
		System.out.println(period);
	}
}
