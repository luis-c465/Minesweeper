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

    board = BoardDifficulties.test(this);
    board.setup();
  }

  @Override
  public void setTitle() {
    surface.setTitle("RICODE Seating");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    helpModal.mouseClicked();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    board.mousePressed(e);
  }

  public void dropdown(int n) {
    if (n == 3) {
      // Go to the time trial mode
      return;
    }

    if (n == 0) {
      board = BoardDifficulties.easy(this);
    } else if (n == 1) {
      board = BoardDifficulties.medium(this);
    } else if (n == 2) {
      board = BoardDifficulties.hard(this);
    }
    board.setup();

    resetSfx();
  }

  public void resetSfx() {
    r.sfx.explosion.rewind();
    r.sfx.explosion.pause();
    r.sfx.freeBird.rewind();
    r.sfx.freeBird.pause();
  }
}
