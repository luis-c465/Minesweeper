package luisc.minesweeper;

import luisc.lib.Obj;
import luisc.lib.PC;
import luisc.resources.Colors;

/**
 * Timer which is automatically started and stopped when the
 */
public class Timer extends Obj {

  int startTime = 0, stopTime = 0;
  boolean running = false;
  public static final int padding = 10;

  @Override
  protected void _setup() {
    super._setup();
  }

  @Override
  protected void preUpdate() {
    super.preUpdate();

    if (!running && a.speedrun && a.board.numMoves == 1 && !a.board.won) {
      start();
    }
  }

  @Override
  protected void _update() {
    if (!a.speedrun) {
      return;
    }

    // Show some information on the screen
    boolean hasStarted = a.board.numMoves > 0;

    p.fill(0);
    p.rectMode(PC.CORNER);
    p.rect(680, 0, 150, 60);

    p.fill(Colors.timer);
    p.textSize(20);
    p.textMode(PC.CORNER);
    p.textAlign(PC.LEFT, PC.CENTER);
    p.text(
      hasStarted
        ? getTimeStr(minute(), second(), milis())
        : getTimeStr(0, 0, 0),
      680 + padding,
      -5,
      110,
      30
    );

    // Show best time
    p.shapeMode(c.CORNER);
    p.shape(r.s.trophy, 680 + padding, 35, 20, 20);
    p.text(
      getTimeStr(
        minute(a.bestTimeMs),
        second(a.bestTimeMs),
        milis(a.bestTimeMs)
      ),
      700 + padding,
      25,
      110,
      30
    );
  }

  private String getTimeStr(int minute, int second, int milis) {
    return String.format("%02d:%02d:%03d", minute, second, milis);
  }

  @Override
  protected void postUpdate() {
    super.postUpdate();

    if (running && a.speedrun && !a.board.inGame) {
      stop();

      if (a.board.won && stopTime - startTime < a.bestTimeMs) {
        a.bestTimeMs = stopTime - startTime;
      }
    }
  }

  public void start() {
    startTime = p.millis();
    running = true;
  }

  public void stop() {
    stopTime = p.millis();
    running = false;
  }

  public int getElapsedTime() {
    int elapsed;
    if (running) {
      elapsed = (p.millis() - startTime);
    } else {
      elapsed = (stopTime - startTime);
    }
    return elapsed;
  }

  public int second() {
    return (getElapsedTime() / 1000) % 60;
  }

  public int milis() {
    return getElapsedTime() % 1000;
  }

  public int milis(int milis) {
    return milis % 1000;
  }

  public int second(int milis) {
    return (milis / 1000) % 60;
  }

  public int minute(int milis) {
    return (milis / (1000 * 60)) % 60;
  }

  public int minute() {
    return (getElapsedTime() / (1000 * 60)) % 60;
  }

  public int hour() {
    return (getElapsedTime() / (1000 * 60 * 60)) % 24;
  }

  public Timer(App a) {
    super(a);
    setup();
  }
}
