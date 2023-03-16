package kr.codesquad.domain.result;

import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.exception.GameProgressException;

import java.util.ArrayList;
import java.util.List;

public class ResultGroup {

    private final List<Result> results;

    public ResultGroup(PlayerGroup playerGroup, DestinationGroup destinationGroup, Ladder ladder) {
        this.results = new ArrayList<>();

        int playerCount = playerGroup.getPlayerCount();

        for(int i = 0; i < playerCount; i++) {
            int resultIndex = ladder.climbDownLadder(i);
            results.add(new Result(playerGroup.getName(i), destinationGroup.getName(resultIndex)));
        }
    }

    //public void add(Result result) {
    //    results.add(result);
    //}

    public String getResult(String playerName) throws GameProgressException {
        if(playerName.equals("--quit")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }

        if(playerName.equals("--restart")) {
            throw new GameProgressException("게임을 다시 시작합니다.");
        }

        StringBuilder sb = new StringBuilder();
        if(playerName.equals("all")) {
            for(Result result : results) {
                sb.append(result.getPlayerName())
                        .append(" : ")
                        .append(result.getDestinationName())
                        .append(System.lineSeparator());
            }
            return sb.toString();
        }

        for (Result result : results) {
            if (result.isPlayerName(playerName)) {
                return result.getDestinationName() + System.lineSeparator();
            }
        }

        throw new IllegalArgumentException("[ERROR] '" + playerName + "'은 존재하지 않습니다.");
    }
}
