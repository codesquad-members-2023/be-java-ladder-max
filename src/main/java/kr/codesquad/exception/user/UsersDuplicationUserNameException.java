package kr.codesquad.exception.user;

public class UsersDuplicationUserNameException extends RuntimeException {

    @Override
    public String getMessage() {
        return "참여자 이름 중에 중복된 이름이 있습니다.";
    }
}
