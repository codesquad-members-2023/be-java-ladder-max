package kr.codesquad;

public class Application {
    private final InputView inputView;
    private final Ladder ladder;

    public Application() {
        inputView = new InputView();
        int n = inputView.getN();
        int maxHeight = inputView.getMaxHeight();
        ladder = new Ladder(n, maxHeight);
    }

    public void run() {
        ladder.generateLegs();
        System.out.println(ladder);
    }
}
