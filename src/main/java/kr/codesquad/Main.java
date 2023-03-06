package kr.codesquad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

        StringTokenizer stringTokenizer = new StringTokenizer(console.returnStringInput(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (token.length() > 5) {
                throw new IOException("[ERROR] 플레이어의 이름은 최대 5글자까지 부여할 수 있습니다.");
            }
            participantList.add(token);
        }
        console.askLadderHeight();
        int ladderShapeHeight = console.returnIntInput();

        LadderShape ladderShape = new LadderShape(ladder, participantList, ladderShapeHeight);
        ladderShape.printLadder();
    }

    private static void startStep1_2() {
        System.out.println("------------step-1, step-2 시작------------");
    }

    private static void startStep3_4() {
        System.out.println();
        System.out.println("------------step-3, step-4 시작------------");
    }
}