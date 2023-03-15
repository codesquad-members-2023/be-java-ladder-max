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

    public List<String> insertResults(int len) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Optional<List<String>> results = parseInput();
        if(!results.isPresent() || !isValidResults(results.get(), len)) {
            System.out.println("각 결과의 길이는 5 이하여야 하거나 결과의 길이가 사람들의 길이가 다릅니다.");
            throw new IllegalArgumentException();
        }
        return results.get();
    }

    private boolean isValidResults(List<String> results, int len) {
        if(results.size() != len) {
            return false;
        }
        return true;
    }

    public int insertHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(this.sc.nextLine());
        if(height < minNum) {
            System.out.println("음수를 입력하셨습니다.");
            throw new IllegalArgumentException();
        }
        return height;
    }

    public List<String> insertNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Optional<List<String>> people = parseInput();
        if(!people.isPresent() || containsDuplicateOrEnd(people.get())) {
            System.out.println("각 이름의 길이는 5 이하여야 합니다. 중복된 이름이 들어가거나 \"춘식이\"란 이름은 사용하실 수 없습니다.");
            throw new IllegalArgumentException();
        }
        return people.get();
    }

    private boolean containsDuplicateOrEnd(List<String> people) {// 중복된 이름 있거나 춘식이란 이름 있는지 검증
        Set<String> peopleSet = new HashSet<>(people);
        if(peopleSet.size() != people.size() || peopleSet.contains("춘식이")) {
            return true;
        }
        return false;
    }

    private Optional<List<String>> parseInput() {
        List<String> list = Arrays.stream(this.sc.nextLine()
                .split(",")).collect(Collectors.toList());
        if(isAnyOverFive(list)) {
            return Optional.empty();
        }
        return Optional.of(list);
    }

    public boolean isAnyOverFive(List<String> people) {
        return people.stream()
                .filter(o -> o.length() > maxLength)
                .findFirst().isPresent();
    }

    public String insertResultName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return this.sc.nextLine();
    }

}
