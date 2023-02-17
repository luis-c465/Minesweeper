package luisc.resources;

import ddf.minim.AudioPlayer;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;

public class Sounds extends ResourceHolder<AudioPlayer> {

  public AudioPlayer explosion;
  public AudioPlayer freeBird;
  public AudioPlayer speedRun;

  @Override
  protected void load() {
    explosion = lf("./explosion.mp3");
    freeBird = lf("./free-bird-riff.mp3");
    speedRun = lf("./speedrun.mp3");

    explosion.setGain(-40f);
    freeBird.setGain(-30f);
    speedRun.setGain(-50f);
  }

  public Sounds(BaseApp p) {
    super(p);
  }

  private AudioPlayer lf(String s) {
    return p.audio.loadFile(s);
  }
}
