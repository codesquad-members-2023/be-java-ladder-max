package mission.view;

import mission.model.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader br;

    public InputView(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getPeopleNumber() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(br.readLine());
    }

    public int getLadderHeight() throws IOException{
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }
}
