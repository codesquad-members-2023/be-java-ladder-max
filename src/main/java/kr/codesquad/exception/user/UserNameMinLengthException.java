package kr.codesquad.exception.user;

import kr.codesquad.domain.User;

public class UserNameMinLengthException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("참여할 사람의 이름은 최소 %d글자입니다.", User.MIN_LENGTH);
    }
}
