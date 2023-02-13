package luisc.seating;

import luisc.lib.Btn;

public class HelpBtn extends Btn {

  @Override
  protected void _setup() {
    x = 650;
    y = 50;

    txt = "Help";
    icon = p.loadShape("help.svg");
    color = 0xff94a3b8;
  }

  @Override
  protected void onClick() {
    // p.println("Show the help modal here!");
    a.helpModal.beginShowing = true;
    p.println(a.helpModal.beginShowing);
  }

  public HelpBtn(App a) {
    super(a);
    setup();
  }
}
