package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Names;

public interface LadderWriter {

    void writeNamesOfPeopleIntro();

    void writeMaximumLadderHeightIntro();

    void writeLadderResultIntro();

    void write(String message);

    void writeNameForLadderResultIntro(Names names);

    void writeLadderResults(LadderResults ladderResults);

    void writeLadderResult(LadderResult ladderResult);
}
