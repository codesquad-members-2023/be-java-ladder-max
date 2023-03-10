package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards createRewards(List<String> rewards) {
        return new Rewards(rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public int getIndex(String name) {
        return IntStream.range(0, rewards.size())
                .filter(index -> rewards.get(index).isSame(name))
                .findFirst()
                .orElseThrow();
    }

    public String getReward(int index) {
        return rewards.get(index).getValue();
    }

    public int getSize() {
        return rewards.size();
    }

    @Override
    public String toString() {
        return rewards.stream()
                .map(value -> value.toString())
                .collect(Collectors.joining());
    }

}
