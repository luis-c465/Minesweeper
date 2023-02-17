package luisc.minesweeper;

public class BoardDifficulties {

  public static Board test(App a) {
    return new Board(a, 1, 15);
  }

  public static Board easy(App a) {
    return new Board(a, 20, 15);
  }

  public static Board medium(App a) {
    return new Board(a, 50, 24);
  }

  public static Board hard(App a) {
    return new Board(a, 125, 40);
  }

  public static Board timeTrial(App a) {
    return new Board(a, 15, 13);
  }

  public static Board skillIssue(App a) {
    return new Board(a, 999, 95);
  }
}
