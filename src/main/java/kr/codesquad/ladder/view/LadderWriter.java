package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Names;

public interface LadderWriter {

    void writeNamesOfPeopleIntro();

    void writeMaximumLadderHeightIntro();

    void writeLadderResultIntro();

    void write(String message);
}
