package kr.codesquad.view;

import java.util.*;
import java.util.stream.Collectors;

import static kr.codesquad.util.Validation.*;

public class InputView {

    private final Scanner sc;


    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public List<String> insertResults(int len) {
        Optional<List<String>> results = Optional.empty();
        while(!checkValidResults(results.orElse(new ArrayList<>()), len)) {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            results = parseInput();
        }
        return results.get();
    }

    public int insertHeight() {
        Optional<String> input = Optional.empty();
        while(!checkValidNumber(input.orElse(null))) {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            input = Optional.of(this.sc.nextLine());
        }
        return Integer.parseInt(input.get());
    }

    public List<String> insertNames() {
        Optional<List<String>> people = Optional.empty();
        while(!checkValidName(people.orElse(new ArrayList<>()))) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            people = parseInput();
        }
        return people.get();
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

    public String insertResultName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return this.sc.nextLine();
    }
}
