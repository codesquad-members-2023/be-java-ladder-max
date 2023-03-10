package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner sc;
    private final int maxLength = 5;
    private final int minNum = 0;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public Ladder enterCommand() {
        return new Ladder(insertNames(), insertResults(), insertHeight());
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

    private int insertHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height;
        try {
            height = Integer.parseInt(insertInput());
            checkMinus(height);
        } catch (NumberFormatException e) {
            System.out.println("올바른 int 숫자 형식이 아니거나 음수를 입력하셨습니다.");
            return insertHeight();
        }
        return height;
    }

    private void checkMinus(int height) {
        if(height < minNum) {
            throw new NumberFormatException();
        }
    }

    private List<String> insertNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people;
        try {
            people = parseInput();
            validateNames(people);
        } catch (IllegalArgumentException e) {
            System.out.println("각 이름의 길이는 5 이하여야 합니다. 중복된 이름이 들어가거나 \"춘식이\"란 이름은 사용하실 수 없습니다.");
            return insertNames();
        }
        return people;
    }

    private void validateNames(List<String> people) {
        Set<String> peopleSet = people.stream().collect(Collectors.toSet());
        if(peopleSet.size() != people.size()
        || peopleSet.contains("춘식이")) { // 중복된 이름 있거나 춘식이가 있는지 검증
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseInput() {
        List<String> list = Arrays.stream(insertInput()
                .split(",")).collect(Collectors.toList());
        if(!isValidNames(list)) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    public boolean isValidNames(List<String> people) {
        return people.stream()
                .filter(o -> o.length() > maxLength)
                .findFirst().isEmpty();
    }

    public String insertInput() {
        return this.sc.nextLine();
    }

}
