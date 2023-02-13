package luisc.resources;

import luisc.lib.ResourceHolder;
import processing.core.PApplet;
import processing.core.PImage;

public class Images extends ResourceHolder<PImage> {

  public PImage intro;
  public PImage tutorial;

  @Override
  protected void load() {
    intro = p.loadImage("intro2.png");
    tutorial = p.loadImage("instructions.png");
  }

  public Images(PApplet p) {
    super(p);
  }
}
