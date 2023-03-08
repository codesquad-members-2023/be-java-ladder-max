package mission.view;

import java.util.List;

public class OutputView {
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printPeopleNameAndLadder(List<String> peopleNames, List<String> ladder){
        appendPeopleName(peopleNames);
        appendLadder(ladder);

        System.out.println(sb); // 모아서 출력
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    public void appendPeopleName(List<String> peopleNames){
        for (String str : peopleNames) {
            sb.append(str);
        }
    }

    public void appendLadder(List<String> ladder){
        for (String str : ladder) {
            sb.append(str);
        }
    }
}
