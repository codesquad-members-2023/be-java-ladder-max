package kr.codesquad.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

public class InputForm {

    @NotBlank
    @Pattern(regexp = "^[a-z]+(,[a-z]+)+$",message = "영어이름을 잘못 입력했습니다.(이름은 쉼표(,)로 구분하세요)")
    private String names;
    @NotBlank
    @Pattern(regexp = "^(꽝|([0-9]+[1-9]*))(,(꽝|([0-9]+[1-9]*)))*$",message = "실행결과를 잘못 입력했습니다.(결과는 쉼표(,)로 구분하세요)")
    private String resultInfo;

    @Range(min = 2,max = 30,message = "2~30 사이의 숫자를 입력하세요.")
    private int ladderHeight;


    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }
}
