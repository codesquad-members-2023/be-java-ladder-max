package kr.codesquad.exception.user;

public class UserNameReservedCommand extends RuntimeException {

    @Override
    public String getMessage() {
        return "입력하신 이름 중에 예약된 명령어가 있습니다.";
    }
}
