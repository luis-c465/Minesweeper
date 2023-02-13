package luisc.minesweeper;

import java.util.LinkedList;
import luisc.lib.BaseApp;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  public boolean paused = false;
  public LinkedList<Student> students = new LinkedList<Student>();

  // Game classes
  public Intro intro;
  public Header header;
  public HelpModal helpModal;

  @Override
  public void draw() {
    defaultSettings();

    intro.update();
    if (doingIntro) {
      return;
    }

    header.update();
    helpModal.update();
  }

  @Override
  protected void setupAppClasses() {
    intro = new Intro(this);
    intro.setup();

    header = new Header(this);
    header.setup();

    helpModal = new HelpModal(this);
    helpModal.setup();
  }

  @Override
  public void setTitle() {
    surface.setTitle("RICODE Seating");
  }

  @Override
  public void mouseClicked() {
    helpModal.mouseClicked();
  }
}
