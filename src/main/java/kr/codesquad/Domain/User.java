package kr.codesquad.Domain;

public class User {
    private String username;
    public User(String username) {
        this.username = username;
    }
    @Override
    public String toString(){
        if(username.length()<=5){
            return " ".repeat((5 - username.length())/2)+username + " ".repeat((5 - username.length())/2)+" ";
        }
        return username;
    }
}
