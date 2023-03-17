package kr.codesquad.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.codesquad.domain.Height;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderRideResult;
import kr.codesquad.domain.Participants;
import kr.codesquad.domain.Results;
import kr.codesquad.generator.RandomLineGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void startLadderGame() {
		Participants participants = getParticipantsFromUser();
		Results results = getResultsFromUser();
		Height height = getHeightFromUser();

		Ladder ladder = createLadder(participants.getParticipants().size(), height.getValue());
		printStateOfLadder(participants.getParticipants(), results.getResults(), ladder.toString());

		LadderRideResult ladderRideResult = new LadderRideResult(participants.getParticipants(),
			rideLadder(ladder, participants), results.getResults());

		rideLadderExecutionResult(ladderRideResult.getLadderRideResult());
	}

	private Participants getParticipantsFromUser() {
		try {
			return new Participants(inputView.getParticipantNames());
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			return getParticipantsFromUser();
		}
	}

	private Results getResultsFromUser() {
		try {
			return new Results(inputView.getExecutionResults());
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			return getResultsFromUser();
		}
	}

	private Height getHeightFromUser() {
		try {
			return new Height(inputView.getHeightOfLadder());
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			return getHeightFromUser();
		}
	}

	private Ladder createLadder(final int countOfPerson, final int height) {
		return new Ladder(countOfPerson, height, new RandomLineGenerator());
	}

	private void printStateOfLadder(final List<String> names, final List<String> results, final String ladder) {
		outputView.printNameOfPeople(names);
		outputView.printFigureOfLadder(ladder);
		outputView.printResultsOfGame(results);
	}

	private List<Integer> rideLadder(final Ladder ladder, final Participants participants) {
		List<Integer> ladderRidePos = new ArrayList<>();
		for (String name : participants.getParticipants()) {
			ladderRidePos.add(ladder.ride(participants.findPosOfParticipant(name)));
		}
		return ladderRidePos;
	}

	private void rideLadderExecutionResult(final Map<String, String> executionResult) {
		String participant = null;
		while (!(participant = inputView.getPersonOfExecutionResult()).equals("춘식이")) {
			String result = executionResult.get(participant);
			outputView.printResult(result);
		}
		outputView.printGameOverMsg();
	}
}
