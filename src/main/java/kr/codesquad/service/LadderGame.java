package kr.codesquad.service;

import kr.codesquad.domain.Ladder;
import kr.codesquad.controller.dto.LadderInputDto;

import java.util.List;

public class LadderGame {

    public String play(List<String> playerNames, LadderInputDto ladderInputDto) {
        final Ladder ladder = ladderInputDto.toLadder();

        return String.join("\n", ladder.createOutputLines());
    }
}
