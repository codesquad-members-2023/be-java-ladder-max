package kr.codesquad.View;

import kr.codesquad.Domain.Line;

import java.util.List;

public class OutputView {
    public static void printLadder(List<Line> ladder){
        ladder.forEach(line-> System.out.println(line.toString()));
    }
}
