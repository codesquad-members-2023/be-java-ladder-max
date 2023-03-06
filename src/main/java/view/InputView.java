package view;

import java.util.Scanner;
import message.ErrorMessage;

public class InputView {

    public static int readNumberOfPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return readInt();
    }

    public static int readLadderSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return readInt();
    }

    private static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.toString());
        }
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        InputValidator.validateHasInput(input);
        return input;
    }

}
