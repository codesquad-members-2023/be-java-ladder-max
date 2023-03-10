package kr.codesquad.view;

import java.util.Scanner;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Users;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Users inputUserNames() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return new Users(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return inputUserNames();
        }
    }

    public static LadderHeight inputLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            return new LadderHeight(SCANNER.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return inputLadderHeight();
        }
    }

    public static void close() {
        SCANNER.close();
    }
}
