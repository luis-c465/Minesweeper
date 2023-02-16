package luisc.minesweeper;

import controlP5.ControlP5;
import controlP5.ScrollableList;
import luisc.lib.Obj;
import luisc.lib.PC;

/**
 * Shows a information about the program
 * and 6 buttons for sorting the list of students
 * Also shows a hel button on how to use the program
 */
public class Header extends Obj {

  public ScrollableList mode;

  public static final int safe = 10;
  public static final int margin_top = 10;
  public static final int h = 100;
  public static final int cy = 50;
  public static final int center = 700 / 2;

  public static final int flags_x = 70;

  public static final int wins_x = 375;
  public static final int losses_x = 475;
  public static final int middle_x = (wins_x + losses_x) / 2;

  public static final int moves_x = 250;

  public HelpBtn helpBtn;

  @Override
  protected void _setup() {
    helpBtn = new HelpBtn(a);

    setupScrollableList();
  }

  private void setupScrollableList() {
    mode =
      a.cp5
        .addScrollableList("dropdown")
        .setPosition(700, 0)
        .setSize(130, 500)
        .setBarHeight(30)
        .setItemHeight(20)
        .addItems(new String[] { "Easy", "Medium", "Hard", "Time Trial" })
        .setLabel("Mode")
        .close();

    mode
      .getValueLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setFont(r.f.nunito)
      .setSize(12);

    mode
      .getCaptionLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setFont(r.f.nunito)
      .setSize(12);
  }

  @Override
  protected void _update() {
    p.textSize(40);
    // p.textAlign(PC.LEFT, PC.BOTTOM);
    showFlags();
    showWinsAndLosses();
    showMoves();
    // showNumMines();

    updateBtns();
  }

  private void showWinsAndLosses() {
    // Wins
    p.shape(
      !a.board.inGame && a.board.won ? r.s.trophy : r.s.trophy_small,
      wins_x - 50,
      cy - 20,
      60,
      60
    );
    p.text("" + a.wins, wins_x, cy);

    // Losses
    p.shape(
      !a.board.inGame && !a.board.won ? r.s.skull : r.s.skull_small,
      losses_x + 50,
      cy - 20,
      60,
      60
    );
    p.text("" + a.losses, losses_x, cy);

    // Middle thing
    p.text("-", middle_x, cy);
  }

  private void showNumMines() {
    p.shape(r.s.mine, flags_x - 40, cy - 20 + 50, 60, 60);
    p.text(a.board.N_MINES, flags_x + 40, cy + 50);
  }

  private void showMoves() {
    p.shape(r.s.moves, moves_x - 70, cy - 20, 60, 60);
    p.text(a.board.numMoves, moves_x, cy);
  }

  private void showFlags() {
    p.shapeMode(PC.CENTER);
    p.shape(r.s.flag, flags_x - 40, cy - 20, 60, 60);
    p.text(a.board.numFlagsLeft, flags_x + 20, cy);
  }

  private void updateBtns() {
    helpBtn.update();
  }

  public Header(App app) {
    super(app);
  }
}
