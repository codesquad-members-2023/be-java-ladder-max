package kr.codesquad;

public class Player {
    private String[] player;
    private int headCount;
    Player(){}
    Player(String str){
        player = str.split(",");
        headCount = player.length;
    }
    public void printPlayer(){
        // 첫번째 플레이어 이름 출력
        System.out.print(player[0]);
        System.out.print(" ".repeat(6-player[0].length()));

        // 가운데 플레이어 이름 출력
        int endIdx = player.length-1;
        for (int i=1;i<endIdx;i++){
            String str = player[i];
            int space = (5-str.length());
            System.out.print(" ".repeat(space/2));
            System.out.print(str);
            System.out.print(" ".repeat((space-space/2)));
            System.out.print(" ".repeat(3));
        }
        // 마지막 플레이어 이름 출력
        if (player[endIdx].length() < 3){
            System.out.print(" ".repeat(3-player[endIdx].length()));
            System.out.println(player[endIdx]);
            return;
        }
        System.out.println(player[endIdx]);
    }
    public int getHeadCount(){
        return headCount;
    }
}
