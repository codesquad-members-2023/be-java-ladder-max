package kr.codesquad.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator {

	private final Random random = new Random();

	public List<Boolean> drawLineRandomly(final int countOfPerson) {
		List<Boolean> points = new ArrayList<>();

		for (int pos = 0; pos < countOfPerson; pos++) {
			points.add(drawLine(pos, points));
		}
		return points;
	}

	private boolean drawLine(final int pos, final List<Boolean> line) {
		if (pos == 0) {
			return random.nextBoolean();
		}
		if (line.get(pos - 1)) {
			return false;
		}
		return random.nextBoolean();
	}
}
