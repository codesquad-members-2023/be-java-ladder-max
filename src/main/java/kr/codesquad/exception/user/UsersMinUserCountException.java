package kr.codesquad.exception.user;

public class UsersMinUserCountException extends RuntimeException {

    @Override
    public String getMessage() {
        return "참여할 사람의 수는 최소 2명입니다.";
    }
}
