package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private final List<LadderLine> ladderLines;
	private final int height;

	public Ladder(final int countOfPerson, final int height) {
		this.ladderLines = new ArrayList<>();
		this.height = height;
		initLadderLines(countOfPerson);
	}

	private void initLadderLines(final int countOfPerson) {
		for (int i = 0; i < height; i++) {
			ladderLines.add(new LadderLine(countOfPerson));
		}
	}

	@Override
	public String toString() {
		StringBuilder figure = new StringBuilder();
		ladderLines
			.forEach(ladderLine -> figure.append(ladderLine).append("\n"));
		return figure.toString();
	}
}
