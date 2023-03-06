package kr.codesquad.application;

import java.util.List;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		final List<String> input = getInputFromUser();
		final Ladder ladder = createLadder(input);
	}

	private List<String> getInputFromUser() {
		outputView.printGetCountOfPersonMsg();
		final String countOfUser = inputView.getInputFromUser();

		outputView.printGetHeightOfLadderMsg();
		final String heightOfLadder = inputView.getInputFromUser();

		return List.of(countOfUser, heightOfLadder);
	}

	private Ladder createLadder(final List<String> input) {
		final Ladder ladder = new Ladder(input);
		ladder.createFigureOfLadder();
		return ladder;
	}
}
