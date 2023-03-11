package kr.codesquad.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class InputForm {

    @NotBlank
    @Pattern(regexp = "^[a-z]+(,[a-z]+)+$")
    private String names;
    @NotBlank
    @Pattern(regexp = "^(꽝|([0-9]+[1-9]*))(,(꽝|([0-9]+[1-9]*)))*$")
    private String resultInfo;

    @NotBlank
    @Pattern(regexp = "^[1-9][0-9]*$")
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
