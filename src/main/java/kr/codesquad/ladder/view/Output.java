package kr.codesquad.ladder.view;


import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.User;

import java.util.List;

public class Output {

    public static void printUser(User user){
        for(String temp : user.userList()) {
            System.out.print(temp);
        }
    }

    public static void drawLadder(List<Line> ladder){
        for(Line temp : ladder){
            System.out.println(temp.toString());
        }
    }
    public static void printAll(User user,List<Line>ladder){
        printUser(user);
        System.out.println();
        drawLadder(ladder);
    }
}
