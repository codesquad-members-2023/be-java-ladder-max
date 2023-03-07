package kr.codesquad.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesquad.domain.Player;
import kr.codesquad.message.ErrorMessage;

public class InputView {

    public static final String PLAYER_DELIMITER_KR = "쉼표";
    public static final String PLAYER_DELIMITER = ",";

    public static List<Player> readPlayers() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n", PLAYER_DELIMITER_KR, PLAYER_DELIMITER);
        String input = readLine();
        InputValidator.validateSeparatedByDelimiter(input, PLAYER_DELIMITER);
        return Stream.of(input.split("\\s*" + PLAYER_DELIMITER + "\\s*"))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static int readLadderSize() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
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
