package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

	private final List<Boolean> points;

	public LadderLine(final List<Boolean> points) {
		this.points = points;
	}

	public LadderLine(final int countOfPerson) {
		this(drawLineRandomly(new Random(), countOfPerson - 1));
	}

	private static List<Boolean> drawLineRandomly(final Random random, final int countOfPerson) {
		List<Boolean> points = new ArrayList<>();

		for (int pos = 0; pos < countOfPerson; pos++) {
			points.add(drawLine(pos, random, points));
		}
		return points;
	}

	private static boolean drawLine(final int pos, final Random random, final List<Boolean> line) {
		if (pos == 0) {
			return random.nextBoolean();
		}
		if (line.get(pos - 1)) {
			return false;
		}
		return random.nextBoolean();
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
