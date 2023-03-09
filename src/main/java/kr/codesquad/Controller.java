package kr.codesquad;

import java.io.IOException;

public class Controller {

    public void run() throws IOException {
        int length = Input2.ladderLength();
        User user = new User(Input2.insertUser());
        MakeLadder makeLadder = new MakeLadder(length, user.userCount());
        Output.printAll(user, makeLadder.listToString());
    }
}