import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    public static int inputPerson(BufferedReader br) throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        try {
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return inputPerson(br);
        }
    }

    public static int inputLine(BufferedReader br) throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return inputLine(br);
        }
    }
}
