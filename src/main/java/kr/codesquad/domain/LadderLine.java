package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

	private final int width;
	private final List<Boolean> isExistsLine;

	public LadderLine(final int countOfPerson) {
		this.width = countOfPerson;
		this.isExistsLine = new ArrayList<>();
		for (int i = 0; i < countOfPerson; i++) {
			isExistsLine.add(false);
		}
	}

	public void drawLineRandomly(final Random random) {
		for (int i = 0; i < width; i++) {
			drawLine(i, random.nextBoolean());
		}
	}

	private void drawLine(final int pos, boolean isDraw) {
		if (pos == 0) {
			isExistsLine.set(pos, isDraw);
			return;
		}
		if (pos == width - 1 && !isExistsLine.get(pos - 1)) {
			isExistsLine.set(width - 1, isDraw);
			return;
		}
		if (!isExistsLine.get(pos - 1) && !isExistsLine.get(pos + 1)) {
			isExistsLine.set(pos, isDraw);
		}
	}

	@Override
	public String toString() {
		StringBuilder ladderLineFigure = new StringBuilder();
		ladderLineFigure.append("|");
		for (int pos = 0; pos < isExistsLine.size(); pos++) {
			drawLine(ladderLineFigure, isExistsLine.get(pos));
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
