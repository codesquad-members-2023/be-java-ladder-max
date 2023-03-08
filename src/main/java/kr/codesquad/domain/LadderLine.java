package kr.codesquad.domain;

import java.util.List;

import kr.codesquad.generator.RandomLineGenerator;

public class LadderLine {

	private final List<Boolean> points;

	public LadderLine(final List<Boolean> points) {
		this.points = points;
	}

	public LadderLine(final int countOfPerson, final RandomLineGenerator generator) {
		this(generator.drawLineRandomly(countOfPerson - 1));
	}

	@Override
	public String toString() {
		StringBuilder ladderLineFigure = new StringBuilder();
		ladderLineFigure.append("  |");
		for (final Boolean isFill : points) {
			drawLine(ladderLineFigure, isFill);
		}
		return ladderLineFigure.toString();
	}

	private void drawLine(final StringBuilder ladderLineFigure, final boolean isFill) {
		if (isFill) {
			ladderLineFigure.append("-----|");
			return;
		}
		ladderLineFigure.append("     |");
	}
}
