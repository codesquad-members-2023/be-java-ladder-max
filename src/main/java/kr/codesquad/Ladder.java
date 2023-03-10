package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<String> namesOfPeople;
    private final int numberOfPeople;
    private final int maximumLadderHeight;

    public Ladder(List<String> namesOfPeople, int maximumLadderHeight) {
        this.namesOfPeople = namesOfPeople;
        this.numberOfPeople = namesOfPeople.size();
        this.maximumLadderHeight = maximumLadderHeight;
    }

    public List<List<String>> createEmptyLadderLines() {
        List<List<String>> emptyLadderLines = new ArrayList<>();
        for (int i = 0; i < maximumLadderHeight; i++) {
            emptyLadderLines.add(new ArrayList<>());
        }
        return emptyLadderLines;
    }

    public int calLineColumnSize() {
        return numberOfPeople * 2 - 1;
    }

    public String getNamesOfPeople() {
        return namesOfPeople.stream()
            .map(name -> String.format("%-5s", name))
            .collect(Collectors.joining(" "));
    }
}
