package luisc.minesweeper;

import luisc.lib.TwoDArrayClickable;

public class BoardSpace extends TwoDArrayClickable {

  @Override
  protected void _update() {
    // TODO Auto-generated method stub

  }

  public BoardSpace(App a, int r, int c) {
    super(a, r, c);

    setup();
  }
}
