package kr.codesquad.exception.ladder;

import kr.codesquad.domain.RowLines;

public class RowLinesMinSizeException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("사다리의 가로라인 개수는 최소 %d개 이어야 합니다.", RowLines.ROW_LINES_MIN_SIZE);
    }
}
