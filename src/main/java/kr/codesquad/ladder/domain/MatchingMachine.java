package kr.codesquad.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatchingMachine {

    private final Ladder ladder;
    private final Names names;
    private final Rewards rewards;

    public MatchingMachine(Ladder ladder, Names names, Rewards rewards) {
        this.ladder = ladder;
        this.names = names;
        this.rewards = rewards;
    }

    public String getMatchingResult(String name) {
        int namesIndex = names.getIndex(name);
        return rewards.getReward(ladder.findLastPosition(namesIndex));
    }

    public Map<String, String> getAllMatchingResult() {
        List<String> rewardResult = getRewardResult();
        return new LinkedHashMap<>(IntStream.range(0, names.getSize()).boxed()
                .collect(Collectors.toMap(names::getName, rewardResult::get)));
    }

    private List<String> getRewardResult() {
        return IntStream.range(0, names.getSize()).mapToObj(index -> getMatchingResult(names.getName(index)))
                .collect(Collectors.toList());
    }

    public String getAllMatchingResultInfo() {
        Map<String, String> matchingResult = getAllMatchingResult();
        final StringBuilder matchBuilder = new StringBuilder();
        matchingResult
                .forEach((name, result) -> matchBuilder
                        .append(name)
                        .append(" : ")
                        .append(result)
                .append(System.lineSeparator()));
        return String.valueOf(matchBuilder);
    }
}
