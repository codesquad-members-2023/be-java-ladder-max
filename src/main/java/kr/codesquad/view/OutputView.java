package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.List;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.println(ladder);

        }


    public void printPeopleList(List<String> nameList) {
        StringBuilder sb = new StringBuilder();
        nameList.forEach(name -> sb.append(centerAligned(name,5)));
        System.out.println(sb);
    }



    private String centerAligned(final String name, final int length) {
        if (name.length() > length) {
            return String.format("%s", name);
        }
        if (name.length() == 4) {
            return String.format(" %s ", name);
        }
        if (name.length() == 5) {
            return String.format("%s ", name);
        }
        final int padding = (length - name.length()) / 2;
        return String.format("%" + padding + "s%s%" + padding + "s ", "", name, "");
    }


}
