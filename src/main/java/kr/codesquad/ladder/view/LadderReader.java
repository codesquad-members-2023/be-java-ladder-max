package kr.codesquad.ladder.view;

import java.util.List;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Names;

public interface LadderReader {

    Names readNameOfPeople();

    LadderGenerator readMaximumLadderHeight();
}
