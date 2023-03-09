package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public void enterCommand() {
        Scanner sc = new Scanner(System.in);
        List<String> names = insertNames(sc);
        List<String> results = insertResults(sc);
        int height = insertHeight(sc);
        Ladder ladder = new Ladder(names.size(), height);
        outputView.printAll(names, ladder.getLadder(), results);
    }

    private List<String> insertResults(Scanner sc) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results;
        try {
            results = parseInput(sc);
        } catch (IllegalArgumentException e) {
            System.out.println("각 결과의 길이는 5 이하여야 합니다.");
            return insertResults(sc);
        }
        return results;
    }

    private List<String> parseInput(Scanner sc) {
        List<String> list = Arrays.stream(sc.nextLine().split(","))
                .collect(Collectors.toList());
        if(!isValidNames(list)) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    private int insertHeight(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height;
        try {
            height = sc.nextInt();
            checkMinus(height);
        } catch (RuntimeException e) {
            System.out.println("올바른 int 숫자 형식이 아니거나 음수를 입력하셨습니다.");
            return insertHeight(sc);
        }
        return height;
    }

    private void checkMinus(int height) {
        if(height < 0) {
            throw new RuntimeException();
        }
    }

    private List<String> insertNames(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people;
        try {
            people = parseInput(sc);
        } catch (IllegalArgumentException e) {
            System.out.println("각 이름의 길이는 5 이하여야 합니다.");
            return insertResults(sc);
        }
        return people;
    }

    public boolean isValidNames(List<String> people) {
        return people.stream()
                .filter(o -> o.length() > 5)
                .findFirst().isEmpty();
    }
}
