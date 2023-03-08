package kr.codesquad;

public class Player {
    private String[] player;
    private int headCount = 1;
    Player(){}
    Player(String str){
        player = str.split(",");
        headCount = player.length;
    }
    public void printPlayer(){
        for (String str : player){
            System.out.print(String.format("%6s", str));
        }
        System.out.println();
    }
    public int getHeadCount(){
        return headCount;
    }
}
