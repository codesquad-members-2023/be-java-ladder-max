package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeConsole implements Printer {
    public ShapeConsole() {
    }

    @Override
    public void askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    @Override
    public void askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public String returnStringInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
