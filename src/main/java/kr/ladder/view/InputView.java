package kr.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final String ASKING_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String ASKING_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. 각 이름은 최대 5글자까지 입니다. (이름은 쉼표(,)로 구분하세요)";
    BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String[] getPlayer() throws IOException {
        System.out.println(ASKING_PLAYER_NAMES);
        return br.readLine().split(",");
    }

    public int getLadderHeight() throws IOException {
        System.out.println(ASKING_LADDER_HEIGHT);
        return Integer.parseInt(br.readLine());
    }
}
