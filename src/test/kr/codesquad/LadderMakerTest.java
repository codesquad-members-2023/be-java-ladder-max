package kr.codesquad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LadderMakerTest {
    @Test
    @DisplayName("printResult()는 제외하고 make() 테스트")
    void makeExceptPrintResult() {
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList("a", "a", "a"));
        int ladderHeight = 2;
        List<List<String>> ladderBoard = new ArrayList<>();
        for (int ladderFloorNum = 0; ladderFloorNum < ladderHeight; ladderFloorNum++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(ladderFloorNum).add("|"); //makeFirstStick
            if (true) {
                ladderBoard.get(ladderFloorNum).add("-----|");
                return;
            }
            ladderBoard.get(ladderFloorNum).add("     |");
            for (int ladderFloorIndex = 2; ladderFloorIndex < namesList.size(); ladderFloorIndex++) {
                int beforeIndex = ladderFloorIndex - 1;
                if (ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("-----|")) {
                    ladderBoard.get(ladderFloorNum).add("     |");
                    return;
                }
                if (true && ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("     |")) {
                    ladderBoard.get(ladderFloorNum).add("-----|");
                    return;
                }
                ladderBoard.get(ladderFloorNum).add("     |");
            }
            for (int i = 0; i < namesList.size(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < namesList.size(); j++) {
                    sb.append(ladderBoard.get(i).get(j));
                }
                assertThat(sb.toString()).isEqualTo("|-----|     |");
            }
        }
    }

    @Test
    @DisplayName("makeRemainParts()의 단위 테스트")
    void makeRemainParts() {
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList("a", "a", "a"));
        List<List<String>> ladderBoard = new ArrayList<>();
        ladderBoard.add(new ArrayList<>());
        ladderBoard.get(0).add("|");
        int ladderFloorNum = 0;
        boolean bool = false;
        if (bool) {
            ladderBoard.get(ladderFloorNum).add("-----|");
            return;
        }
        ladderBoard.get(ladderFloorNum).add("     |");
        for (int ladderFloorIndex = 2; ladderFloorIndex < namesList.size(); ladderFloorIndex++) {
            int beforeIndex = ladderFloorIndex - 1;
            if (ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("-----|")) {
                ladderBoard.get(ladderFloorNum).add("     |");
                return;
            }
            if (bool && ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("     |")) {
                ladderBoard.get(ladderFloorNum).add("-----|");
                return;
            }
            ladderBoard.get(ladderFloorNum).add("     |");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ladderBoard.get(0).get(0));
        sb.append(ladderBoard.get(0).get(1));
        sb.append(ladderBoard.get(0).get(2));
        assertThat(sb.toString()).isEqualTo("|     |     |");
    }

    @Test
    @DisplayName("makeFirstBridgeVersionTrue ()의 단위 테스트")
    void makeFirstBridgeVersionTrue() {
        boolean bool = true;
        List<List<String>> ladderBoard = new ArrayList<>();
        ladderBoard.add(new ArrayList<>());
        if (bool) {
            ladderBoard.get(0).add("-----|");
            return;
        }
        ladderBoard.get(0).add("     |");
        assertThat(ladderBoard.get(0)).extracting("String").contains("-----|");
    }

    @Test
    @DisplayName("makeFirstBridgeVersionFalse()의 단위 테스트")
    void makeFirstBridgeVersionFalse() {
        boolean bool = false;
        List<List<String>> ladderBoard = new ArrayList<>();
        ladderBoard.add(new ArrayList<>());
        if (bool) {
            ladderBoard.get(0).add("-----|");
            return;
        }
        ladderBoard.get(0).add("     |");
        assertThat(ladderBoard.get(0)).isNotEmpty().contains("     |");
    }

    @Test
    @DisplayName("makeBridgeNotContinuous()의 단위 테스트")
    void makeBridgeNotContinuous() {
        List<List<String>> ladderBoard = new ArrayList<>();
        ladderBoard.add(new ArrayList<>());
        int ladderFloorsNum = 0;
        int ladderFloorIndex = 1;
        ladderBoard.get(0).add("-----|");
        boolean bool = false;
        int beforeIndex = ladderFloorIndex - 1;
        if (ladderBoard.get(ladderFloorsNum).get(beforeIndex).equals("-----|")) {
            ladderBoard.get(ladderFloorsNum).add("     |");
            return;
        }
        if (bool && ladderBoard.get(ladderFloorsNum).get(beforeIndex).equals("     |")) {
            ladderBoard.get(ladderFloorsNum).add("-----|");
            return;
        }
        ladderBoard.get(ladderFloorsNum).add("     |");
        StringBuilder sb = new StringBuilder();
        sb.append(ladderBoard.get(0).get(0));
        sb.append(ladderBoard.get(0).get(1));
        assertThat(sb.toString()).isEqualTo("-----|      |");
    }
}
