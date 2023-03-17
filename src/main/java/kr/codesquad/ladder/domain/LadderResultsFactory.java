package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResultsFactory {

    public LadderResults getAllLadderResult(Names names, Ladder ladder,
        Destinations destinations) {
        List<LadderResult> ladderResultList = new ArrayList<>();
        for (Name name : names) {
            int columnByName = names.findIndexByName(name);
            int dstIndex = ladder.climb(columnByName);
            Destination destination = destinations.get(dstIndex);
            ladderResultList.add(new LadderResult(name, destination));
        }
        return new LadderResults(ladderResultList);
    }
}
