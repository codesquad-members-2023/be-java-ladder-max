package kr.codesquad.View;

import kr.codesquad.Domain.Line;
import kr.codesquad.Domain.User;

import java.util.List;

public class OutputView {
    public static void printLadder(List<Line> ladder){
        ladder.forEach(line-> System.out.println(line.toString()));
    }
    public static void printUsers(List<User> users){
        users.forEach(user-> System.out.print(user.toString()));
        System.out.println();
    }
}
