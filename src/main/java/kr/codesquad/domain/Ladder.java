package kr.codesquad.domain;

import java.util.List;
import java.util.Random;

public class Ladder {

	private final int width;
	private final int height;
	private final String[][] figureOfLadder;

	public Ladder(final List<String> input) {
		this.width = Integer.parseInt(input.get(0)) * 2 - 1;
		this.height = Integer.parseInt(input.get(1));
		this.figureOfLadder = new String[height][width];
	}

	public void createFigureOfLadder() {
		for (int row = 0; row < height; row++) {
			createVerticalLineOfLadder(row);
			createHorizonLineOfLadder(row);
		}
	}

	private void createVerticalLineOfLadder(final int row) {
		for (int col = 0; col < width; col += 2) {
			figureOfLadder[row][col] = "|";
		}
	}

	private void createHorizonLineOfLadder(final int row) {
		Random random = new Random();

		for (int col = 1; col < width; col += 2) {
			if (random.nextBoolean()) {
				figureOfLadder[row][col] = "-";
				continue;
			}
			figureOfLadder[row][col] = " ";
		}
	}
}
