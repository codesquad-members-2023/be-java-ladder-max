package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner sc;
    private static final int maxLength = 5;
    private static final int minLimit = 0;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public List<String> insertResults(int len) {
        Optional<List<String>> results = Optional.empty();
        while(!checkValidResults(results, len)) {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            results = parseInput();
        }
        return results.get();
    }

    private boolean checkValidResults(Optional<List<String>> opResults, int len) {
        if(opResults.isEmpty()) {
            return false;
        }
        List<String> results = opResults.get();
        if(results.size() != len) {
            System.out.println("결과의 길이가 참여한 사람들의 길이와 다릅니다.");
            return false;
        }
        return true;
    }

    public int insertHeight() {
        Optional<String> input = Optional.empty();
        while(!checkValidNumber(input)) {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            input = Optional.of(this.sc.nextLine());
        }
        return Integer.parseInt(input.get());
    }

    private boolean checkValidNumber(Optional<String> opInput) {
        if(opInput.isEmpty()) {
            return false;
        }
        try {
            int num = Integer.parseInt(opInput.get());
            return checkLimit(num);
        } catch (NumberFormatException e) {
            System.out.println("올바른 int 숫자 형식이 아닙니다.");
            return false;
        }
    }

    private boolean checkLimit(int num) {
        if(num < minLimit) {
            System.out.println("입력되는 숫자는 0보다 작을 수 없습니다.");
            return false;
        }
        return true;
    }

    public List<String> insertNames() {
        Optional<List<String>> people = Optional.empty();
        while(!checkValidName(people)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            people = parseInput();
        }
        return people.get();
    }

    private boolean checkValidName(Optional<List<String>> opPeople) {// 중복된 이름 있거나 춘식이란 이름 있는지 검증
        if(opPeople.isEmpty()) {
            return false;
        }
        List<String> people = opPeople.get();
        Set<String> peopleSet = new HashSet<>(people);
        if(peopleSet.size() != people.size() || peopleSet.contains("춘식이")) {
            System.out.println("중복된 이름이 들어가거나 \"춘식이\"란 이름은 사용하실 수 없습니다.");
            return false;
        }
        return true;
    }

    private Optional<List<String>> parseInput() {
        List<String> list = Arrays.stream(this.sc.nextLine()
                .split(",")).collect(Collectors.toList());
        if(isAnyOverFive(list)) {
            System.out.println("각 입력의 길이는 5 이하여야 합니다.");
            return Optional.empty();
        }
        return Optional.of(list);
    }

    public boolean isAnyOverFive(List<String> people) {
        return people.stream()
                .anyMatch(o -> o.length() > maxLength);
    }

    public String insertResultName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return this.sc.nextLine();
    }

}
