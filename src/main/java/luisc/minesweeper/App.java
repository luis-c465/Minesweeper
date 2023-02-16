package luisc.minesweeper;

import java.util.LinkedList;
import luisc.lib.BaseApp;
import processing.event.MouseEvent;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  public int wins = 0;
  public int losses = 0;
  public LinkedList<Student> students = new LinkedList<Student>();

  // Game classes
  public Intro intro;
  public Header header;
  public HelpModal helpModal;
  public Board board;

  @Override
  public void draw() {
    defaultSettings();

    // intro.update();
    // if (doingIntro) {
    //   return;
    // }

    header.update();
    helpModal.update();

    board.update();
  }

  @Override
  protected void setupAppClasses() {
    // intro = new Intro(this);
    // intro.setup();

    header = new Header(this);
    header.setup();

    helpModal = new HelpModal(this);
    helpModal.setup();

    board = BoardDifficulties.easy(this);
    board.setup();
  }

  @Override
  public void setTitle() {
    surface.setTitle("RICODE Seating");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    helpModal.mouseClicked();
    board.mouseClicked(e);
  }
}
