package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final String BLANK = " ";
    private final String NEWLINE = "\n";
    private final int LAST_LENGTH = 1;
    private final List<User> users = new ArrayList<>();

    public Users(String[] userNames) {
        for (String userName : userNames) {
            users.add(new User(userName));
        }
    }

    public int count() {
        return users.size();
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.toString());
            sb.append(BLANK.repeat(user.findNamesBlank()));
        }
        sb.replace(sb.length() - LAST_LENGTH, sb.length(), NEWLINE);
        return sb.toString();
    }
}
