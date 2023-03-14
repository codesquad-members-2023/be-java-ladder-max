package kr.codesquad.domain;

import kr.codesquad.exception.GameProgressException;

import java.util.ArrayList;
import java.util.List;

public class ResultGroup {

    private final List<Result> results;

    public ResultGroup() {
        this.results = new ArrayList<>();
    }

    public void add(Result result) {
        results.add(result);
    }

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
