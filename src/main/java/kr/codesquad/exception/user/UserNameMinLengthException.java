package kr.codesquad.exception.user;

public class UserNameMinLengthException extends RuntimeException {

    @Override
    public String getMessage() {
        return "참여할 사람의 이름은 최소 1글자입니다.";
    }
}
