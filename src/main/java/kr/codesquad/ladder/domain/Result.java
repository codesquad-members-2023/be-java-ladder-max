package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.domain.dto.ResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private String resultName;

    public Result(String resultName) {
        this.resultName = resultName;
    }

    public List<String> resultList(){
        return Arrays.stream(resultName.split(","))
                .collect(Collectors.toList());
    }

    private String formatName(String temp) {
        return String.format("%-6s",temp);
    }

    @Override
    public String toString() {
        return resultList().stream()
                .map(this::formatName)
                .collect(Collectors.joining());
    }
}
