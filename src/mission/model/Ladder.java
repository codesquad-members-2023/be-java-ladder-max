package mission.model;

import java.util.Random;

public class Ladder {
    private String[][] ladder;

    public Ladder(){}

    public void makeLadder(int peopleNumber, int ladderHeight) {
        String[][] ladder = new String[ladderHeight][peopleNumber+(peopleNumber-1)];
        for (int i = 0; i < ladder.length; i++) {
            checkIndex(ladder[i], i);
        }

        /* 2중 for 문을 stream 으로 개선하려 했지만 실패.

        AtomicInteger index = new AtomicInteger();
        for (String[] ladderRow : ladder) {
            ladderRow = Arrays.stream(ladderRow).map(e -> ((index.getAndIncrement() % 2) == 0) ? "|" : randomHyphenOrBlank()).collect(Collectors.toList()).toArray(new String[0]);
        }
         */

        this.ladder = ladder;
    }

    private void checkIndex(String[] ladderI, int i){
        for (int j = 0; j < ladderI.length; j++) {
            makePipe(ladderI, j);
            makeHyphenOrBlank(ladderI, j);
        }
    }

    private void makePipe(String[] ladderI, int j){
        if (j % 2 == 0) {
            ladderI[j] = "|";
        }
    }

    private void makeHyphenOrBlank(String[] ladderI, int j){
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
