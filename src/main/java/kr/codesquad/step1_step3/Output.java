package kr.codesquad.step1_step3;

public class Output {
    public static void printUser(User user){
        for(String temp : user.userList()) {
            System.out.print(temp);

        }
    }
    public static void printLadder(String ladder){
        System.out.println(ladder);
    }

    public static void printAll(User user, String ladder){
        printUser(user);
        printLadder(ladder);
    }



}