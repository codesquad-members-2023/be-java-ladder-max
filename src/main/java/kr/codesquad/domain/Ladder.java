package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Names names;
    private List<LadderRow> radder = new ArrayList<>();

    public Ladder(String nameData, int height){
        String[] nameArr = nameData.split(",");
        names = new Names(nameArr);

        for(int i=0; i<height; i++){
            radder.add(new LadderRow(nameArr.length-1));
        }
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n사다리 출력\n");
        // 이름 row
        sb.append(names.makeNameRow() + "\n");
        // 사다리 row
        for(int i=0; i<radder.size(); i++){
            sb.append(radder.get(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
