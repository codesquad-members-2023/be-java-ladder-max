package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputPlayerCount() throws IOException, NumberFormatException {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(br.readLine());
    }

    public String[] inputPlayerNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] playerNames = br.readLine().replace(" ", "").split(",");
        validatePlayerNames(playerNames);
        return playerNames;
    }

    public int inputLadderHeight() throws IOException, NumberFormatException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }

    /* validation */
    private void validatePlayerNames(String[] playerNames) {
        for(String playerName : playerNames) {
            validatePlayerName(playerName);
        }
    }

    private void validatePlayerName(String playerName) {
        if(playerName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이내로 입력해 주세요.(※ " + playerName + ")");
        }
    }
}
