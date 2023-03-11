package kr.codesquad.exception.user;

import kr.codesquad.domain.Users;

public class UsersMinUserCountException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("참여할 사람의 수는 최소 %d명입니다.", Users.MIN_USER_NAMES_COUNT);
    }
}
