package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {

	private static final Random random = new Random();
	private static final List<String> horizonLineContainer = List.of("-", " ");

	private final int width;
	private final int height;
	private final String[][] figureOfLadder;

	public Ladder(final Input input) {
		this.width = input.getNamesOfPerson().size() * 2 - 1;
		this.height = input.getHeightOfLadder();
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
		for (int col = 1; col < width; col += 2) {
			figureOfLadder[row][col] = horizonLineContainer.get(random.nextInt(2));
		}
	}

	@Override
	public String toString() {
		StringBuilder figure = new StringBuilder();
		Arrays.stream(figureOfLadder)
			.forEach(line -> figure.append(String.join("", line)).append("\n"));
		return figure.toString();
	}
}
