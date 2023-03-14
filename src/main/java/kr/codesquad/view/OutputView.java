package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderLine;

import java.util.List;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.println(ladder);
//        for (LadderLine ladderRow : ladder) {
////            for (String s : ladderRow) {
////                System.out.print(s);
////            }
//            System.out.println();
        }


    /*
    정렬하기 위한 메서드 추ㅣㅁ
     */

//    public static String centerString(int width, String s) {
//        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
//    }

    public void printPeopleList(List<String> nameList) {
        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i) + " ");
        }
        System.out.println();
    }


}
