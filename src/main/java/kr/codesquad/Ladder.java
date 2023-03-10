package kr.codesquad;

public class Ladder {
  private final boolean[][] ladder;

  public Ladder(boolean[][] ladder) {
    this.ladder = ladder;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < ladder.length; row++) {
      for (int col = 0; col < ladder[0].length-1; col++) {
        if (ladder[row][col]) {
          sb.append("|-");
          continue;
        }
        sb.append("| ");
      }
      sb.append("|\n");
    }
    return String.valueOf(sb);
  }
}
