package luisc.lib;

import controlP5.ControlP5;
import java.util.ArrayList;
import luisc.minesweeper.App;
import luisc.resources.Resources;
import processing.core.PApplet;

/**
 * Base class for all apps
 */
public abstract class BaseApp extends PApplet {

  public boolean doingIntro = true;
  public boolean doingStartUp = true;
  public boolean transitioning = false;

  public ArrayList<Obj> objects = new ArrayList<>();

  // * Util classes
  public Resources r;

  // * luisc.seating.library classes
  public ControlP5 cp5;

  // Transition classes
  public TransitionIn transIn;
  public TransitionOut transOut;

  // * CONSTANTS
  public static final int h = 1000;
  public static final int w = 1000;

  public static final int ch = 500;
  public static final int cw = 500;

  public static final String[] appletArgs = {
    "--display=1",
    "luisc.minesweeper.App",
  };

  // * COLORS
  public static final int bg = 0xff1e293b;

  @Override
  public void settings() {
    size(1000, 1000);
  }

  @Override
  public void setup() {
    setTitle();
    defaultSettings();
    setupUtilAndLib();
    setupAppClasses();
  }

  public abstract void setTitle();

  /**
   * Really this should not be used
   * Only call if you are lazy
   */
  protected void updateObjects() {
    for (Obj o : objects) {
      o.update();
    }
  }

  /**
   * Setups util and library classes
   */
  protected void setupUtilAndLib() {
    r = new Resources(this);
    cp5 = new ControlP5(this);

    transIn = new TransitionIn((App) this);
    transOut = new TransitionOut((App) this);
    transIn.setup();
    transOut.setup();
  }

  protected abstract void setupAppClasses();

  public static void main(String[] args) {
    runSketch(appletArgs, null);
  }

  /**
   * Sets the default settings for drawing with processing
   */
  public void defaultSettings() {
    frameRate(30);
    smooth();
    background(bg);
    shapeMode(CENTER);
    textAlign(CENTER);
    imageMode(CENTER);
    noStroke();

    // Default fill color is white
    fill(255);
  }
}
