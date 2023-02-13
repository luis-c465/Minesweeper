package luisc.minesweeper;

import luisc.lib.Btn;
import luisc.lib.Transitionable;
import processing.core.PImage;

public class Intro extends Transitionable {

  PImage[] slides;
  int maxSlide = -1;
  int index = 0;

  ContBtn contBtn;
  BackBtn backBtn;

  protected void _setup() {
    slides = new PImage[] { r.i.intro, r.i.tutorial };
    maxSlide = slides.length - 1;

    contBtn = new ContBtn(a);
    backBtn = new BackBtn(a);

    contBtn.setup();
    backBtn.setup();
  }

  protected void _update() {
    p.image(slides[index], a.cw, a.ch);

    contBtn.update();
    backBtn.update();

    if (contBtn.clicked) {
      p.println("woah clicked");
      if (index == maxSlide) {
        trans = true;
      } else if ((index + 1) <= maxSlide) {
        index++;
      }
    } else if (backBtn.clicked && (index - 1) >= 0) {
      index--;
    }
  }

  protected void onTransOutBegin() {
    a.doingIntro = false;
  }

  // Uses cont
  private class ContBtn extends Btn {

    public static final String cont = "Next";
    public static final String sta = "Start";

    protected void _setup() {
      w = 100;
      h = 50;

      x = App.w - 10 - w;
      y = App.h - 10;

      txt_size = 20;
      icon_size = 30;

      txt = cont;
      icon = p.loadShape("continue.svg");

      cornerToCenter();
    }

    protected void preUpdate() {
      super.preUpdate();

      // Update the txt
      // and maybe the icon
      if (index == maxSlide) {
        txt = sta;
      } else {
        txt = cont;
      }
    }

    public ContBtn(App app) {
      super(app);
    }
  }

  // Uses back as an icon
  private class BackBtn extends Btn {

    protected void _setup() {
      w = 100;
      h = 50;

      x = 10;
      y = App.h - 10;

      txt_size = 20;
      icon_size = 30;

      txt = "Back";
      icon = p.loadShape("back.svg");

      cornerToCenter();
    }

    public BackBtn(App app) {
      super(app);
    }
  }

  public Intro(App app) {
    super(app);
  }
}
