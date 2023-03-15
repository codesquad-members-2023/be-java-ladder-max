package kr.codesquad.controller.dto;

import kr.codesquad.domain.LadderResult;

import java.util.List;

public class LadderOutputDto {
    private final List<String> outputLines;
    private final LadderResult ladderResult;

    public LadderOutputDto(List<String> outputLines, LadderResult ladderResult) {
        this.outputLines = outputLines;
        this.ladderResult = ladderResult;
    }

    public String getLadderShape() {
        return String.join("\n", outputLines);
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
