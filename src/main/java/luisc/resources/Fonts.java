package luisc.resources;

import luisc.lib.ResourceHolder;
import processing.core.PApplet;
import processing.core.PFont;

public class Fonts extends ResourceHolder<PFont> {

  public PFont nunito;
  // !Smaller versions of fonts are loaded because controlP5 does not give a method to set the font size of the input text
  public PFont nunito_small;
  public PFont nunito_smaller;

  @Override
  protected void load() {
    nunito = p.createFont("fonts/Nunito.ttf", 64);
    nunito_small = p.createFont("fonts/Nunito.ttf", 20);
    nunito_smaller = p.createFont("fonts/Nunito.ttf", 20);
    p.textFont(nunito);
  }

  public Fonts(PApplet p) {
    super(p);
  }
}
