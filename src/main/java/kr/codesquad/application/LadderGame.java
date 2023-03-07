package kr.codesquad.application;

import java.util.List;

import kr.codesquad.domain.Height;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Participants;
import kr.codesquad.generator.RandomLineGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		try {
			final Participants participants = getParticipantsFromUser();
			final Height height = getHeightFromUser();

			final Ladder ladder = createLadder(participants.getParticipants().size(), height.getValue());
			printStateOfLadder(participants.getParticipants(), ladder);
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			startLadderGame();
		}
	}

	private Participants getParticipantsFromUser() {
		outputView.printGetNamesOfPersonMsg();
		final String namesOfPerson = inputView.getInputFromUser();

		return new Participants(namesOfPerson);
	}

	private Height getHeightFromUser() {
		outputView.printGetHeightOfLadderMsg();
		final String heightOfLadder = inputView.getInputFromUser();

		return new Height(heightOfLadder);
	}

	private Ladder createLadder(final int countOfPerson, final int height) {
		return new Ladder(countOfPerson, height, new RandomLineGenerator());
	}

	private void printStateOfLadder(final List<String> names, final Ladder ladder) {
		outputView.printNameOfPeople(names);
		outputView.printFigureOfLadder(ladder);
	}
}
