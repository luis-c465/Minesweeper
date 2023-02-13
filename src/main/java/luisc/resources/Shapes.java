package luisc.resources;

import luisc.lib.ResourceHolder;
import processing.core.PApplet;
import processing.core.PShape;

public class Shapes extends ResourceHolder<PShape> {

  public PShape skull;
  public PShape userMinus;
  public PShape rows;
  public PShape columns;

  @Override
  protected void load() {
    skull = p.loadShape("skull.svg");
    userMinus = p.loadShape("user-minus.svg");

    rows = p.loadShape("rows.svg");
    columns = p.loadShape("columns.svg");
  }

  public Shapes(PApplet p) {
    super(p);
  }
}
