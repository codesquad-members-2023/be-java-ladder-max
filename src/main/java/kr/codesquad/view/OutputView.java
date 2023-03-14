package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;

public class Outputview {

    public void printLadder(List<List<String>> ladder){
        for(List<String> ladderRow : ladder){
            for (String s : ladderRow) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void printPeopleList(List<String> nameList){
        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i)+" ");
        }
        System.out.println();
    }




}
