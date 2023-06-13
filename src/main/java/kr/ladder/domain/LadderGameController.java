package kr.ladder.domain;


import kr.ladder.view.InputView;
import kr.ladder.view.OutputView;

import java.io.IOException;

public class LadderGameController {
    private final Ladder ladder;
    private final InputValidation validation;
    private final ResultRepository resultRepository;

    public LadderGameController() {
        this.ladder = new Ladder();
        this.validation = new InputValidation();
        this.resultRepository = new ResultRepository();
    }

    public void run() throws IOException {
        // 입력
        String[] players = validation.inspectPlayers();
        String[] prizes = validation.inspectPrizes(players.length);
        int ladderHeight = validation.inspectLadderHeight();
        // 사다리 만들기
        ladder.make(players.length, ladderHeight);
        // 플레이어와 경품 맵핑하기
        resultRepository.mapping(ladder.play(), players, prizes, ladder.generate());
        // 결과를 보고 싶은 사람 입력 받기
        String command = validation.inspectCommand(players);
        // 출력
        while (!command.equals("춘식이")) {
            resultRepository.printPrize(command);
            command = validation.inspectCommand(players);
        }
        // 종료
        exit();
    }

    private void exit() {
        resultRepository.exit();
    }
}
