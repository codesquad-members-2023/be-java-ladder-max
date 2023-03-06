package mission.model;

import java.util.Random;

public class Ladder {
    private String[][] ladder;

    public Ladder(){}

    public void makeLadder(int peopleNumber, int ladderHeight) {
        String[][] ladder = new String[ladderHeight][peopleNumber+(peopleNumber-1)];
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                makePipe(ladder[i], j);
                makeHyphen(ladder[i], j);
            }
        }
        this.ladder = ladder;
    }

    private void makePipe(String[] ladderI, int j){
        if (j % 2 == 0) {
            ladderI[j] = "|";
        }
    }

    private void makeHyphen(String[] ladderI, int j){
        if (j % 2 == 1) {
            ladderI[j] = randomChar(); // 랜덤으로 들어가게 함.
        }
    }

    private String randomChar(){
        Random random = new Random();
        if (random.nextBoolean()) {
            return "-"; // true
        }
        return " "; // false
    }

    public String[][] getLadder(){
        return ladder;
    }
}
