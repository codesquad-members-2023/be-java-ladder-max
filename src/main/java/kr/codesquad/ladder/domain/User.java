package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    String name;

    public User(String name) {
        this.name = name;
    }

    public List<String> userList(){
        List<String> userList = new ArrayList<>();
        String listArr[] = name.split(",");
        for(String temp : listArr) {
            userList.add(formatName(temp));
        }
        return userList;
    }

    public String formatName(String temp) {
        return String.format("%-6s",temp);
    }



}
