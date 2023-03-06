package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {

	private static final Random random = new Random();

	private final List<LadderLine> ladderLines;
	private final int width;
	private final int height;

	public Ladder(final Input input) {
		this.ladderLines = new ArrayList<>();
		this.width = input.getNamesOfPerson().size();
		this.height = input.getHeightOfLadder();
		initLadderLines();
	}

	private void initLadderLines() {
		for (int i = 0; i < height; i++) {
			ladderLines.add(new LadderLine(width));
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
