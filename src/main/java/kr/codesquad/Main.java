
package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        Scanner sc = new Scanner(System.in);
        try {
            new Ladder(insertNames(sc), insertHeight(sc));
        } catch (RuntimeException e) { // InputMismatchException이 RuntimeException을 상속받음.
            System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
            enterCommand();
        }
    }

    private static int insertHeight(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        if(height < 0) {
            throw new RuntimeException();
        }
        return height;
    }

    private static List<String> insertNames(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people = Arrays.stream(sc.nextLine().split(","))
                .collect(Collectors.toList());

        if(!isValidNames(people)) {
            throw new RuntimeException();
        }
        return people;
    }

    public static boolean isValidNames(List<String> people) {
        return people.stream()
                .filter(o -> o.length() > 5)
                .findFirst().isEmpty();
    }

}