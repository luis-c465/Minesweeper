package luisc.minesweeper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Random;
import processing.core.PApplet;

public class Student {

  public static final DateTimeFormatter dateParser = getDateInputFormatter();
  public static final Random rand = new Random();

  public String firstName;
  public String lastName;
  public String id;
  public int id_i;
  public LocalDate dob;
  private String dob_str_cache;
  public boolean alreadySeated;

  @Override
  public String toString() {
    return (toNameString() + " #" + id + " dob: " + dateParser.format(dob));
  }

  public String toDisplayString() {
    return toNameString() + " #" + id + "     dob: " + dateParser.format(dob);
  }

  public String toNameString() {
    return lastName + ", " + firstName;
  }

  public String toIdString() {
    return "#" + id;
  }

  public String getDOBString() {
    if (dob_str_cache == null) {
      dob_str_cache = dateParser.format(dob);
    }

    return dob_str_cache;
  }

  /**
   * @returns String containing the students first, last name, and id
   */
  public String toShortString() {
    return toNameString() + " #" + id;
  }

  public Student(PApplet p, String name, String id, String dob) {
    String[] nameSplit = name.split(" ");

    this.firstName = nameSplit[0];
    this.lastName = nameSplit[1];
    this.id = id;
    this.id_i = Integer.parseInt(id);
    this.dob = LocalDate.from(dateParser.parse(dob));
    // this.img = p.loadImage("students/" + imgUrl);
  }

  public Student(PApplet p, String name, String id, LocalDate dob) {
    String[] nameSplit = name.split(" ");

    this.firstName = nameSplit[0];
    this.lastName = nameSplit[1];
    this.id = id;
    this.id_i = Integer.parseInt(id);
    this.dob = dob;
    // this.img = p.loadImage("students/" + imgUrl);
  }

  public Student(PApplet p, String name) {
    this(p, name, randId(), randDate());
  }

  public static final String randId() {
    return "0" + (rand.nextInt(999_999 - 100_000 + 1) + 100_000);
  }

  public static final LocalDate randDate() {
    int minDay = (int) LocalDate.of(2004, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2009, 1, 1).toEpochDay();
    long randomDay = minDay + rand.nextInt(maxDay - minDay);

    return LocalDate.ofEpochDay(randomDay);
  }

  public static DateTimeFormatter getDateInputFormatter() {
    return new DateTimeFormatterBuilder()
      .parseCaseInsensitive()
      .parseLenient()
      .optionalStart()
      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral("/")
      .appendValue(ChronoField.DAY_OF_MONTH, 2)
      .optionalEnd()
      .appendLiteral('/')
      .appendValue(ChronoField.YEAR_OF_ERA, 4) // 2 digit year not handled
      .toFormatter();
  }
}
