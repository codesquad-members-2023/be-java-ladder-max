package kr.codesquad.application;

import java.util.ArrayList;
import java.util.List;

import kr.codesquad.domain.Height;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Participants;
import kr.codesquad.domain.Results;
import kr.codesquad.generator.RandomLineGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		try {
			final Participants participants = getParticipantsFromUser();
			final Results results = getResultsFromUser();
			final Height height = getHeightFromUser();

			final Ladder ladder = createLadder(participants.getParticipants().size(), height.getValue());
			printStateOfLadder(participants.getParticipants(), results.getResults(), ladder);
			List<Integer> resultPos = rideLadder(ladder, participants, results);
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

	private Results getResultsFromUser() {
		outputView.printGetResultsMsg();
		final String results = inputView.getInputFromUser();

		return new Results(results);
	}

	private Height getHeightFromUser() {
		outputView.printGetHeightOfLadderMsg();
		final String heightOfLadder = inputView.getInputFromUser();

		return new Height(heightOfLadder);
	}

	private Ladder createLadder(final int countOfPerson, final int height) {
		return new Ladder(countOfPerson, height, new RandomLineGenerator());
	}

	private void printStateOfLadder(final List<String> names, final List<String> results, final Ladder ladder) {
		outputView.printNameOfPeople(names);
		outputView.printFigureOfLadder(ladder);
		outputView.printResultsOfGame(results);
	}

	private List<Integer> rideLadder(final Ladder ladder, final Participants participants, final Results results) {
		List<Integer> resultPos = new ArrayList<>();
		for (String participant : participants.getParticipants()) {
			resultPos.add(ladder.ride(participants.findPosOfParticipant(participant)));
		}
		return resultPos;
	}
}
