package luisc.minesweeper;

import luisc.lib.Obj;
import luisc.lib.PC;

/**
 * Shows a information about the program
 * and 6 buttons for sorting the list of students
 * Also shows a hel button on how to use the program
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int margin_top = 10;
  public static final int h = 100;
  public static final int cy = 50;
  public static final int center = 700 / 2;

  public static final int flags_x = 100;

  public static final int wins_x = 450;
  public static final int losses_x = 550;
  public static final int middle_x = (wins_x + losses_x) / 2;

  public HelpBtn helpBtn;

  @Override
  protected void _setup() {
    helpBtn = new HelpBtn(a);
  }

  @Override
  protected void _update() {
    showFlags();
    showWinsAndLosses();

    updateBtns();
  }

  private void showWinsAndLosses() {
    // Wins
    p.shape(r.s.trophy, wins_x - 50, cy - 20, 60, 60);
    p.text("" + a.wins, wins_x, cy);

    // Losses
    p.shape(r.s.skull, losses_x + 50, cy - 20, 60, 60);
    p.text("" + a.losses, losses_x, cy);

    // Middle thing
    p.text("-", middle_x, cy);
  }

  private void showFlags() {
    p.shapeMode(PC.CENTER);
    p.shape(r.s.flag, flags_x - 40, cy - 20, 60, 60);
    p.text(a.board.numFlagsLeft, flags_x + 40, cy);
  }

  private void updateBtns() {
    helpBtn.update();
  }

  public Header(App app) {
    super(app);
  }
}
