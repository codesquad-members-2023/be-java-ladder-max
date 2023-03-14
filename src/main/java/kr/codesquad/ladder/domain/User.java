package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public List<String> userList(){
        return Arrays.stream(name.split(","))
                .map(this::formatName)
                .collect(Collectors.toList());
    }

    private String formatName(String temp) {
        return String.format("%-6s",temp);
    }

    @Override
    public String toString() {
        return userList().stream()
                .collect(Collectors.joining());
    }

}
