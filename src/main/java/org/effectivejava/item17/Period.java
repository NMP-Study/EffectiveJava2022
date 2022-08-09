package org.effectivejava.item17;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {

	private Date start;
	private Date end;

	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(String.format("%s가 %s보다 늦다", this.start, this.end));
		}
	}

	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	public String toString() {
		return start + " - " + end;
	}

	// 가변 공격을 막는다
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		start = new Date(start.getTime());
		end = new Date(end.getTime());

		if (start.compareTo(end) > 0) {
			throw new InvalidObjectException(String.format("%s가 %s보다 늦다", this.start, this.end));
		}
	}
}
