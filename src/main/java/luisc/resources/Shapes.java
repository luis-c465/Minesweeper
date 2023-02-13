package luisc.resources;

import luisc.lib.ResourceHolder;
import processing.core.PApplet;
import processing.core.PShape;

public class Shapes extends ResourceHolder<PShape> {

  public PShape skull;
  public PShape flag;

  @Override
  protected void load() {
    skull = p.loadShape("skull.svg");
    flag = p.loadShape("flag.svg");
  }

  public Shapes(PApplet p) {
    super(p);
  }
}
