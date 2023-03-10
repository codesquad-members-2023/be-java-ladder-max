package kr.codesquad.domain;

public class Participant {

	private final String name;
	private final int pos;

	public Participant(String name, int pos) {
		this.name = name;
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
