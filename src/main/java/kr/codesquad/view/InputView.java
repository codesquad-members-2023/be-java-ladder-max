package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView;
    private final Scanner sc;
    private Ladder ladder;

    public InputView() {
        this.outputView = new OutputView();
        this.sc = new Scanner(System.in);
    }

    public void enterCommand() {
        this.ladder = new Ladder(insertNames(), insertResults(), insertHeight());
    }

    private List<String> insertResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results;
        try {
            results = parseInput();
        } catch (IllegalArgumentException e) {
            System.out.println("각 결과의 길이는 5 이하여야 합니다.");
            return insertResults();
        }
        return results;
    }

    private List<String> parseInput() {
        List<String> list = Arrays.stream(this.sc.nextLine()
                        .split(",")).collect(Collectors.toList());
        if(!isValidNames(list)) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    private int insertHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height;
        try {
            height = Integer.parseInt(this.sc.nextLine());
            checkMinus(height);
        } catch (NumberFormatException e) {
            System.out.println("올바른 int 숫자 형식이 아니거나 음수를 입력하셨습니다.");
            return insertHeight();
        }
        return height;
    }

    private void checkMinus(int height) {
        if(height < 0) {
            throw new NumberFormatException();
        }
    }

    private List<String> insertNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people;
        try {
            people = parseInput();
        } catch (IllegalArgumentException e) {
            System.out.println("각 이름의 길이는 5 이하여야 합니다.");
            return insertResults();
        }
        return people;
    }

    public boolean isValidNames(List<String> people) {
        return people.stream()
                .filter(o -> o.length() > 5)
                .findFirst().isEmpty();
    }

    public void seeResult() {
        while (true) {
            System.out.println();
            System.out.println("결과를 보고 싶은 사람은?");
            ladder.findResult(this.sc.nextLine());
        }
    }
}
