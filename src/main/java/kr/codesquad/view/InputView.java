package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String[] inputPlayerNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return br.readLine().replace(" ", "").split(",");
    }

    public String[] inputDestinationNames() throws IOException {
        System.out.println("도착 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return br.readLine().replace(" ", "").split(",");
    }

    public int inputLadderHeight() throws IOException, NumberFormatException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }

    public String inputSelectPlayer() throws IOException {
        System.out.println("결과를 보고 싶은 사람은? (프로그램 종료 : --quit, 다시 시작: --restart)");
        return br.readLine();
    }

}
