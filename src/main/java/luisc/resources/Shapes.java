package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PShape;

public class Shapes extends ResourceHolder<PShape> {

  public PShape skull;
  public PShape skull_small;
  public PShape flag;
  public PShape trophy;
  public PShape trophy_small;
  public PShape moves;
  public PShape mine;

  @Override
  protected void load() {
    skull = p.loadShape("skull.svg");
    skull_small = p.loadShape("skull-blank.svg");
    flag = p.loadShape("flag.svg");
    trophy = p.loadShape("trophy.svg");
    trophy_small = p.loadShape("trophy-blank.svg");
    moves = p.loadShape("box.svg");
    mine = p.loadShape("mine.svg");
  }

  public Shapes(BaseApp p) {
    super(p);
  }
}
