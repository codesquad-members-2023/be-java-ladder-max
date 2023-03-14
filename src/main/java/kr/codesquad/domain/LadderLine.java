package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<String> ladderRow;
    private LadderColumn ladderColumn = new LadderColumn();
    /*
    어떤 상태와 행위를 가지고 있어야하는가?
    -> 질문을 해봤을 때,

    |  |  |
    |  |  |
    |  |  |
     */


    LadderLine(){
        this.ladderRow = new ArrayList<>();
    }


    public void makeLadderRow(int ladderHeight){
        for (int row = 0; row < ladderHeight; row++) {
            ladderRow.add()
        }

    }
}
