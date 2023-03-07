package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

	private static final Random random = new Random();

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

	public void createFigureOfLadder() {
		for (int row = 0; row < height; row++) {
			createHorizonLineOfLadder(row);
		}
	}

	private void createHorizonLineOfLadder(final int row) {
		ladderLines.get(row).drawLineRandomly(random);
	}

	@Override
	public String toString() {
		StringBuilder figure = new StringBuilder();
		ladderLines
			.forEach(ladderLine -> figure.append(ladderLine).append("\n"));
		return figure.toString();
	}
}
