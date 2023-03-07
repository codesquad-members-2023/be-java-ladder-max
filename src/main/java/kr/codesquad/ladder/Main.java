package kr.codesquad.ladder;

import kr.codesquad.ladder.view.Console;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderShape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();

        // step-1, step-2
        startStep1_2();
        console.askParticipantsNumber();
        int participantNumber = console.returnIntInput();
        console.askLadderHeight();
        int ladderHeight = console.returnIntInput();

        Ladder ladder = new Ladder(participantNumber, ladderHeight);
        ladder.printLadder();

        // 개행
        System.out.println();

        // step-3, step-4
        startStep3_4();
        List<String> participantList = new ArrayList<>();
        console.askParticipantsName();

        addParticipantsFromTokenizer(participantList, Arrays.asList(console.returnStringInput().split("\\s*" + "," + "\\s*")));
        console.askLadderHeight();
        int ladderShapeHeight = console.returnIntInput();

        LadderShape ladderShape = new LadderShape(participantList, ladderShapeHeight);
        ladderShape.printLadder();
    }

    private static void addParticipantsFromTokenizer(List<String> participantList, Iterable<String> iterable) {
        // StringTokenizer -> 구식 ㅠㅠ
        // Java 11부터 사용하지 않는 것을 권장
        // 이제부터 Iterable<> 쓰자
        for (String token : iterable) {
            validatePlayerName(token);
            participantList.add(token);
        }
    }

    private static void validatePlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("플레이어의 이름은 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    private static void startStep1_2() {
        System.out.println("------------step-1, step-2 시작------------");
    }

    private static void startStep3_4() {
        System.out.println();
        System.out.println("------------step-3, step-4 시작------------");
    }
}