package kr.codesquad.application;

import java.util.List;

import kr.codesquad.domain.Input;
import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		try {
			final Input input = getInputFromUser();
			final Ladder ladder = createLadder(input);
			printStateOfLadder(input.getNamesOfPerson(), ladder);
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			startLadderGame();
		}
	}

	private Input getInputFromUser() {
		outputView.printGetNamesOfPersonMsg();
		final String namesOfPerson = inputView.getInputFromUser();

		outputView.printGetHeightOfLadderMsg();
		final String heightOfLadder = inputView.getInputFromUser();

		return new Input(namesOfPerson, heightOfLadder);
	}

	private Ladder createLadder(final Input input) {
		final Ladder ladder = new Ladder(input);
		ladder.createFigureOfLadder();
		return ladder;
	}

	private void printStateOfLadder(final List<String> names, final Ladder ladder) {
		outputView.printNameOfPeople(names);
		outputView.printFigureOfLadder(ladder);
	}
}
