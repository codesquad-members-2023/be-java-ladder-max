package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.Ladder;

public interface LadderWriter {

    void writeNamesOfPeopleIntro();

    void writeMaximumLadderHeightIntro();

    void writeInvalidReadNumber(String message);

    void writeLadder(String ladder);

    void writeNamesOfPeople(Ladder ladder);
}
