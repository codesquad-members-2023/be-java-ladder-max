package kr.codesquad.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderRideResult {

	private final Map<String, String> ladderRideResult;

	public LadderRideResult(List<String> participants, List<Integer> rideResultPos, List<String> results) {
		ladderRideResult = rideLadder(participants, rideResultPos, results);
	}

	private Map<String, String> rideLadder(final List<String> participants, final List<Integer> rideResultPos,
		final List<String> results) {
		Map<String, String> ladderRideResult = new HashMap<>();
		for (int idx = 0; idx < participants.size(); idx++) {
			ladderRideResult.put(participants.get(idx), results.get(rideResultPos.get(idx)));
		}

		storeTotalResultOfGame(ladderRideResult);
		return ladderRideResult;
	}

	private void storeTotalResultOfGame(final Map<String, String> executionResult) {
		StringBuilder totalResultBuilder = new StringBuilder();
		for (Map.Entry<String, String> entry : executionResult.entrySet()) {
			totalResultBuilder.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
		}
		executionResult.put("all", totalResultBuilder.toString());
	}

	public Map<String, String> getLadderRideResult() {
		return Collections.unmodifiableMap(ladderRideResult);
	}
}
