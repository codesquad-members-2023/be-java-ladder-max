package kr.codesquad.view;

import java.util.List;

import kr.codesquad.domain.Ladder;

public class OutputView {

	public void printErrorMsg(final Exception e) {
		System.out.println(e.getMessage());
	}

	public void printNameOfPeople(final List<String> names) {
		StringBuilder nameBuilder = new StringBuilder();
		names.forEach(name -> nameBuilder.append(centerAligned(name, 5)));
		System.out.println(nameBuilder);
	}

	public void printResultsOfGame(final List<String> results) {
		StringBuilder resultBuilder = new StringBuilder();
		results.forEach(result -> resultBuilder.append(centerAligned(result, 5)));
		System.out.println(resultBuilder);
	}

	private String centerAligned(final String name, final int length) {
		if (name.length() > length) {
			return String.format("%s", name);
		}
		if (name.length() == 4) {
			return String.format(" %s ", name);
		}
		if (name.length() == 5) {
			return String.format("%s ", name);
		}
		final int padding = (length - name.length()) / 2;
		return String.format("%" + padding + "s%s%" + padding + "s ", "", name, "");
	}

	public void printFigureOfLadder(final Ladder ladder) {
		System.out.print(ladder);
	}

	public void printResult(final String executionResult) {
		System.out.println(String.format("\n실행결과\n%s", executionResult));
	}

	public void printGameOverMsg() {
		System.out.println("\n게임을 종료합니다.");
	}
}
