package Ladder2;

import Ladder2.domain.Ladder;
import Ladder2.domain.Participants;
import Ladder2.view.Output;
import java.io.IOException;


public class RunLadder {
    public static void main(String[] args) throws IOException {
        Participants participants = new Participants();
        Ladder ladder = new Ladder(participants.getNames().size());


        Output output = new Output();
        output.print(participants.toString() + ladder.toString());
    }
}
