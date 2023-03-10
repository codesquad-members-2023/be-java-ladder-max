package step1;

import java.util.Random;

public class Ladder {
    private static final int WALL = 0;
    private static final int BLANK_OR_ROW = 2;
    private static final int EVEN= 2;
    Random random;
    int participatePeople;
    int ladderHeight;
    int [][] map;

    public Ladder(int participatePeople, int ladderHeight) {
        this.participatePeople = participatePeople;
        this.ladderHeight = ladderHeight;
        map = new int[participatePeople][ladderHeight];
        random = new Random();
    }

    public StringBuilder createLadder(){
        StringBuilder sb = new StringBuilder();
        makeLadder(sb);
        return sb;
    }

    public void makeLadder(StringBuilder sb){
        for(int i=0; i<ladderHeight; i++){
            for(int j=0; j<=participatePeople+1; j++){
                if(j%EVEN == WALL){
                    sb.append(LadderType.HEIGHT.getLadderType());
                }else{
                    int randomConnectionLadder = random.nextInt(BLANK_OR_ROW);
                    sb.append(LadderType.findConnectionLadder(randomConnectionLadder).getLadderType());
                }
            }
            sb.append("\n");
        }
    }
}
