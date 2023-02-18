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
  public AppIntro intro;
  public Header header;
  public HelpModal helpModal;
  public Board board;
  public boolean speedrun = false;
  public int bestTimeMs = Integer.MAX_VALUE;

  @Override
  public void draw() {
    defaultSettings();

    intro.update();
    if (doingIntro) {
      return;
    }

    header.update();

    board.update();
    helpModal.update();
  }

  @Override
  protected void setupAppClasses() {
    intro = new AppIntro(this);
    intro.setup();

    header = new Header(this);
    header.setup();

    helpModal = new HelpModal(this);
    helpModal.setup();

    board = BoardDifficulties.easy(this);
    board.setup();
  }

  @Override
  public void setTitle() {
    surface.setTitle("RICODE Minesweeper");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    helpModal.mouseClicked();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (!helpModal.show) {
      board.mousePressed(e);
    }
  }

  public void dropdown(int n) {
    if (n == 0) {
      board = BoardDifficulties.easy(this);
      speedrun = false;
    } else if (n == 1) {
      board = BoardDifficulties.medium(this);
      speedrun = false;
    } else if (n == 2) {
      board = BoardDifficulties.hard(this);
      speedrun = false;
    } else if (n == 3) {
      board = BoardDifficulties.timeTrial(this);
      speedrun = true;
    }

    board.setup();

    resetSfx();
  }

  public void resetSfx() {
    r.sfx.explosion.rewind();
    r.sfx.explosion.pause();

    r.sfx.freeBird.rewind();
    r.sfx.freeBird.pause();

    r.sfx.speedRun.rewind();
    r.sfx.speedRun.pause();
  }
}
