package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;

public interface LadderReader {

    String[] readNamesOfPeoples();

    int readMaximumLadderHeight();

    String[] readDestinations();

    String readNameOfPeopleForLadderResult(Names names);
}
