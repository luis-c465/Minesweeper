package luisc.minesweeper;

import luisc.lib.Obj;

/**
 * Shows a information about the program
 * and 6 buttons for sorting the list of students
 * Also shows a hel button on how to use the program
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int margin_top = 10;
  public static final int h = 100;
  public static final String title = "Seating Chart";
  public static final String r_string = "Rows";
  public static final String c_string = "Cols";
  public static final int center = 700 / 2;
  public static final int bts_begin_y = 125;
  public static final int bts_begin_y_2 = bts_begin_y * 2 + 20;
  public static final int x1 = 200;
  public static final int x2 = 400;
  public static final int x3 = 600;

  public HelpBtn helpBtn;

  @Override
  protected void _setup() {
    helpBtn = new HelpBtn(a);
  }

  @Override
  protected void _update() {
    showHeader();

    showRowsAndColsLabel();

    updateBtns();
  }

  private void showRowsAndColsLabel() {
    p.shapeMode(c.CORNER);
    p.textAlign(c.CORNER);
    p.textSize(30);
    p.text(r_string, safe, bts_begin_y);
    p.text(c_string, safe, bts_begin_y * 2 + safe);

    p.shape(r.s.rows, safe, bts_begin_y + 20, 40, 40);
    p.shape(r.s.columns, safe, bts_begin_y * 2 + 20 + safe, 40, 40);
  }

  private void showHeader() {
    p.textAlign(c.CENTER);
    p.text(title, center, 55);
  }

  private void updateBtns() {
    helpBtn.update();
  }

  public Header(App app) {
    super(app);
  }
}
