package luisc.resources;

import luisc.lib.ResourceHolder;
import processing.core.PApplet;
import processing.core.PShape;

public class Shapes extends ResourceHolder<PShape> {

  public PShape skull;
  public PShape flag;
  public PShape trophy;
  public PShape moves;
  public PShape mine;

  @Override
  protected void load() {
    skull = p.loadShape("skull.svg");
    flag = p.loadShape("flag.svg");
    trophy = p.loadShape("trophy.svg");
    moves = p.loadShape("box.svg");
    mine = p.loadShape("mine.svg");
  }

  public Shapes(PApplet p) {
    super(p);
  }
}
