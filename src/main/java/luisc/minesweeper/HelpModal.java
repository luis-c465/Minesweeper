package luisc.minesweeper;

import luisc.lib.FullScreenModal;

public class HelpModal extends FullScreenModal {

  @Override
  protected void _setup() {
    img = r.i.tutorial;
  }

  @Override
  protected void _update() {
    super._update();
  }

  public HelpModal(App a) {
    super(a);
  }
}
