package kr.codesquad;

public class LadderGame {
    void run(){
        Output output = new Output();
        Input input =new Input();
        Ladder ladder;
        int numberOfPlayers;
        int ladderHeight;

        output.printInputNumberOfPlayerQuestion();
        numberOfPlayers = input.inputNumberOfPlayers();
        output.printInputLadderHeightQuestion();
        ladderHeight = input.inputLadderHeight();

        ladder = new Ladder(numberOfPlayers, ladderHeight);
        output.printLadder(ladder);
    }
}
