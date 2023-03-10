package kr.codesquad;

public class Player {
  private final String name;
  private int col;
  private int row;

  public Player(String name, int col) {
    this.name = name;
    this.col = col;
    this.row = 0;
  }
}
