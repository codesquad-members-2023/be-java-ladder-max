package kr.codesquad.exception.ladder;

import kr.codesquad.domain.LadderHeight;

public class LadderMinHeightException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("사다리 높이는 최소 %d이상 입니다.", LadderHeight.MIN_HEIGHT);
    }
}
