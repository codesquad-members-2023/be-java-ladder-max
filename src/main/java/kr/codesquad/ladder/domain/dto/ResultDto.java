package kr.codesquad.ladder.domain.dto;

public class ResultDto {
    private String userName;
    private String result;

    public ResultDto(String userName, String result) {
        this.userName = userName;
        this.result = result;
    }

    public String getUserName() {
        return userName;
    }

    public String getResult() {
        return result;
    }

}
