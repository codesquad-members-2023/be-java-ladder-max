package kr.codesquad;

public class Ladder {
    private final LadderPart[][] map;

    public Ladder(int player, int height) {
        map = new LadderPart[height][player * 2 - 1];
        makeMap();
    }

    private void makeMap() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                map[y][x] = LadderPart.create(x);
            }
        }
    }

    public void print() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }
}
