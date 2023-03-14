package kr.codesquad.ladder.view;


import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.User;

import java.util.List;

public class Output {

    public static void printUser(String user){
        System.out.println(user);
    }
    public static void drawLadder(String ladderShape){
        System.out.println(ladderShape);
    }
    public static void printAll(String user,String ladderShape,String result){
        printUser(user);
        drawLadder(ladderShape);
        System.out.println(result);
    }
}
