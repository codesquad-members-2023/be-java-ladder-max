package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderResults implements Iterable<LadderResult> {

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = new ArrayList<>(ladderResults);
    }

    @Override
    public Iterator<LadderResult> iterator() {
        return ladderResults.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderResult ladderResult : ladderResults) {
            sb.append(ladderResult).append("\n");
        }
        return sb.toString();
    }
}
