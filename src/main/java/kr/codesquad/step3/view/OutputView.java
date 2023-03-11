package kr.codesquad.step3.view;

import kr.codesquad.step3.domain.Ladder;
import kr.codesquad.step3.domain.LadderType;
import kr.codesquad.step3.domain.Participates;

public class OutputView {
    public static void showParticipates(Participates participates){
        System.out.println("\n 실행결과 \n");
        participates.participatesNames.stream()
                .map(name -> String.format("%6s",name.getName()))
                .forEach(System.out::print);
        System.out.println();
    }
}
