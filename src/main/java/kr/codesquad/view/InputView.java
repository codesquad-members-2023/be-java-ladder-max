package kr.codesquad.view;

import java.util.Scanner;
import kr.codesquad.domain.Users;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Users inputNumberOfUsers() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String userNames = SCANNER.nextLine();
            return new Users(userNames);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return inputNumberOfUsers();
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return SCANNER.nextInt();
    }

    public static void close() {
        SCANNER.close();
    }
}
