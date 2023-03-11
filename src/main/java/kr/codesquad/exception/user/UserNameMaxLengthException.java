package kr.codesquad.exception.user;

public class UserNameMaxLengthException extends RuntimeException {

    @Override
    public String getMessage() {
        return "참여할 사람의 이름은 최대 5글자입니다.";
    }
}
