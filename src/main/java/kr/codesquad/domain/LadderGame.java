package kr.codesquad.domain;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LadderGame {

    private ArrayList<String> names;
    private ArrayList<String> results;
    private int countOfLadder;
    public void startLadderGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input();
        Validator validator = new Validator();
        boolean checkName = true, checkResult = true, checkLadder = true;
        int position = -1;

        while (checkName) {
            String answer = input.input(br, 0);
            String[] arrayNames = splitAnswer(answer);
            checkName = checkNames(validator, arrayNames);
        }

        while (checkResult) {
            String answer = input.input(br, 1);
            String[] arrayResults = splitAnswer(answer);
            checkResult = checkResults(validator, arrayResults, names.size());
        }

        while (checkLadder) {
            String answer = input.input(br, 2);
            checkLadder = checkLadder(validator, input, answer);
        }

        Ladder ladder = new Ladder(names.size(), countOfLadder);
        Output output = new Output();
        output.print(names, ladder, results);

        while (true) {
            String resultPerson = input.input(br, 3);
            if(resultPerson.equals("춘식이")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            for (int i = 0; i < names.size(); i++) {
                if(resultPerson.equals(names.get(i))) {
                    position = i;
                }
            }
            if(position == -1 && !resultPerson.equals("all")) {
                System.out.println("이름을 다시 입력해주세요.");
                continue;
            }
            output.printResultPerson(ladder, results, position, names.size(), countOfLadder);
        }
    }

    private boolean checkNames(Validator validator, String[] arrayNames) {
        if(validator.validateNames(arrayNames)) {
            names = new ArrayList<>(Arrays.asList(arrayNames));
            return false;
        }
        return true;
    }

    private boolean checkResults(Validator validator, String[] arrayResults, int namesSize) {
        if(validator.validateResults(arrayResults, namesSize)) {
            results = new ArrayList<>(Arrays.asList(arrayResults));
            return false;
        }
        return true;
    }

    private boolean checkLadder(Validator validator, Input input, String answer) {
        if(validator.validateLadder(answer)) {
            countOfLadder = input.inputLadder(answer);
            return false;
        }
        return true;
    }

    private String[] splitAnswer(String answer) {
        return answer.replaceAll(" ", "").split(",");
    }
}
