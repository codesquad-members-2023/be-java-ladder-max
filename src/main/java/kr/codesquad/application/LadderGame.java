package kr.codesquad.application;

import java.util.List;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		List<String> input = getInputFromUser();
	}

	private List<String> getInputFromUser() {
		outputView.printGetCountOfPersonMsg();
		final String countOfUser = inputView.getInputFromUser();

		outputView.printGetHeightOfLadderMsg();
		final String heightOfLadder = inputView.getInputFromUser();

		return List.of(countOfUser, heightOfLadder);
	}
}
