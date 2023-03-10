package kr.codesquad.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			printStateOfLadder(participants.getParticipants(), results.getResults(), ladder.toString());

			rideLadderExecutionResult(rideLadder(ladder, participants, results));
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMsg(e);
			startLadderGame();
		}
	}

	private Participants getParticipantsFromUser() {
		final String namesOfPerson = inputView.getParticipantNames();

		return new Participants(namesOfPerson);
	}

	private Results getResultsFromUser() {
		final String results = inputView.getExecutionResults();

		return new Results(results);
	}

	private Height getHeightFromUser() {
		final String heightOfLadder = inputView.getHeightOfLadder();

		return new Height(heightOfLadder);
	}

	private Ladder createLadder(final int countOfPerson, final int height) {
		return new Ladder(countOfPerson, height, new RandomLineGenerator());
	}

	private void printStateOfLadder(final List<String> names, final List<String> results, final String ladder) {
		outputView.printNameOfPeople(names);
		outputView.printFigureOfLadder(ladder);
		outputView.printResultsOfGame(results);
	}

	private Map<String, String> rideLadder(final Ladder ladder, final Participants participants,
		final Results results) {
		Map<String, String> executionResult = new HashMap<>();
		for (String participant : participants.getParticipants()) {
			int rideResultPos = ladder.ride(participants.findPosOfParticipant(participant));
			executionResult.put(participant, results.getResultOfPos(rideResultPos));
		}
		storeTotalResultOfGame(executionResult);
		return executionResult;
	}

	private void storeTotalResultOfGame(final Map<String, String> executionResult) {
		StringBuilder totalResultBuilder = new StringBuilder();
		for (Map.Entry<String, String> entry : executionResult.entrySet()) {
			totalResultBuilder.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
		}
		executionResult.put("all", totalResultBuilder.toString());
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
