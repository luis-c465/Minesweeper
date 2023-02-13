package luisc.minesweeper;

import luisc.lib.Obj;
import luisc.lib.PC;
import processing.core.PImage;

public class Board extends Obj {

  private final int NUM_IMAGES = 13;
  private final int CELL_SIZE = 30;

  private final int COVER_FOR_CELL = 10;
  private final int MARK_FOR_CELL = 10;
  private final int EMPTY_CELL = 0;
  private final int MINE_CELL = 9;
  private final int COVERED_MINE_CELL = MINE_CELL + COVER_FOR_CELL;
  private final int MARKED_MINE_CELL = COVERED_MINE_CELL + MARK_FOR_CELL;

  private final int DRAW_MINE = 9;
  private final int DRAW_COVER = 10;
  private final int DRAW_MARK = 11;
  private final int DRAW_WRONG_MARK = 12;

  private final int N_MINES = 40;
  private final int N_ROWS = 16;
  private final int N_COLS = 16;

  private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
  private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE + 1;

  public static final int LEFT_MARGIN = 100;
  public static final int TOP_MARGIN = 200;

  private int[] field;
  private boolean inGame;
  private int minesLeft;
  private PImage[] img;

  private int allCells;
  private String statusbar = "";

  @Override
  protected void _setup() {
    initBoard();
  }

  @Override
  protected void _update() {
    paintComponent();
  }

  private void initBoard() {
    img = new PImage[NUM_IMAGES];

    for (int i = 0; i < NUM_IMAGES; i++) {
      String path = "minesweeper/" + i + ".png";
      img[i] = p.loadImage(path);
    }

    newGame();
  }

  private void newGame() {
    int cell;

    inGame = true;
    minesLeft = N_MINES;

    allCells = N_ROWS * N_COLS;
    field = new int[allCells];

    for (int i = 0; i < allCells; i++) {
      field[i] = COVER_FOR_CELL;
    }

    statusbar = Integer.toString(minesLeft);

    int i = 0;

    while (i < N_MINES) {
      int position = (int) (allCells * a.rand.nextDouble());

      if ((position < allCells) && (field[position] != COVERED_MINE_CELL)) {
        int current_col = position % N_COLS;
        field[position] = COVERED_MINE_CELL;
        i++;

        if (current_col > 0) {
          cell = position - 1 - N_COLS;
          if (cell >= 0) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }
          cell = position - 1;
          if (cell >= 0) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }

          cell = position + N_COLS - 1;
          if (cell < allCells) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }
        }

        cell = position - N_COLS;
        if (cell >= 0) {
          if (field[cell] != COVERED_MINE_CELL) {
            field[cell] += 1;
          }
        }

        cell = position + N_COLS;
        if (cell < allCells) {
          if (field[cell] != COVERED_MINE_CELL) {
            field[cell] += 1;
          }
        }

        if (current_col < (N_COLS - 1)) {
          cell = position - N_COLS + 1;
          if (cell >= 0) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }
          cell = position + N_COLS + 1;
          if (cell < allCells) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }
          cell = position + 1;
          if (cell < allCells) {
            if (field[cell] != COVERED_MINE_CELL) {
              field[cell] += 1;
            }
          }
        }
      }
    }
  }

  private void find_empty_cells(int j) {
    int current_col = j % N_COLS;
    int cell;

    if (current_col > 0) {
      cell = j - N_COLS - 1;
      if (cell >= 0) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }

      cell = j - 1;
      if (cell >= 0) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }

      cell = j + N_COLS - 1;
      if (cell < allCells) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }
    }

    cell = j - N_COLS;
    if (cell >= 0) {
      if (field[cell] > MINE_CELL) {
        field[cell] -= COVER_FOR_CELL;
        if (field[cell] == EMPTY_CELL) {
          find_empty_cells(cell);
        }
      }
    }

    cell = j + N_COLS;
    if (cell < allCells) {
      if (field[cell] > MINE_CELL) {
        field[cell] -= COVER_FOR_CELL;
        if (field[cell] == EMPTY_CELL) {
          find_empty_cells(cell);
        }
      }
    }

    if (current_col < (N_COLS - 1)) {
      cell = j - N_COLS + 1;
      if (cell >= 0) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }

      cell = j + N_COLS + 1;
      if (cell < allCells) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }

      cell = j + 1;
      if (cell < allCells) {
        if (field[cell] > MINE_CELL) {
          field[cell] -= COVER_FOR_CELL;
          if (field[cell] == EMPTY_CELL) {
            find_empty_cells(cell);
          }
        }
      }
    }
  }

  public void paintComponent() {
    int uncover = 0;

    for (int i = 0; i < N_ROWS; i++) {
      for (int j = 0; j < N_COLS; j++) {
        int cell = field[(i * N_COLS) + j];

        if (inGame && cell == MINE_CELL) {
          inGame = false;
        }

        if (!inGame) {
          if (cell == COVERED_MINE_CELL) {
            cell = DRAW_MINE;
          } else if (cell == MARKED_MINE_CELL) {
            cell = DRAW_MARK;
          } else if (cell > COVERED_MINE_CELL) {
            cell = DRAW_WRONG_MARK;
          } else if (cell > MINE_CELL) {
            cell = DRAW_COVER;
          }
        } else {
          if (cell > COVERED_MINE_CELL) {
            cell = DRAW_MARK;
          } else if (cell > MINE_CELL) {
            cell = DRAW_COVER;
            uncover++;
          }
        }

        p.imageMode(PC.CORNER);
        p.image(
          img[cell],
          LEFT_MARGIN + (j * CELL_SIZE),
          TOP_MARGIN + (i * CELL_SIZE),
          CELL_SIZE,
          CELL_SIZE
        );
      }
    }

    if (uncover == 0 && inGame) {
      inGame = false;
      statusbar = "Game won";
    } else if (!inGame) {
      statusbar = "Game lost";
    }
  }

  public void mouseClicked(processing.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    int cCol = (x - LEFT_MARGIN) / CELL_SIZE;
    int cRow = (y - TOP_MARGIN) / CELL_SIZE;

    boolean doRepaint = false;

    if (!inGame) {
      newGame();
      return;
    }

    if ((x < N_COLS * CELL_SIZE) && (y < N_ROWS * CELL_SIZE)) {
      if (e.getButton() == PC.RIGHT) {
        if (field[(cRow * N_COLS) + cCol] > MINE_CELL) {
          doRepaint = true;

          if (field[(cRow * N_COLS) + cCol] <= COVERED_MINE_CELL) {
            if (minesLeft > 0) {
              field[(cRow * N_COLS) + cCol] += MARK_FOR_CELL;
              minesLeft--;
              String msg = Integer.toString(minesLeft);
              statusbar = msg;
            } else {
              statusbar = ("No marks left");
            }
          } else {
            field[(cRow * N_COLS) + cCol] -= MARK_FOR_CELL;
            minesLeft++;
            String msg = Integer.toString(minesLeft);
            statusbar = (msg);
          }
        }
      } else {
        if (field[(cRow * N_COLS) + cCol] > COVERED_MINE_CELL) {
          return;
        }

        if (
          (field[(cRow * N_COLS) + cCol] > MINE_CELL) &&
          (field[(cRow * N_COLS) + cCol] < MARKED_MINE_CELL)
        ) {
          field[(cRow * N_COLS) + cCol] -= COVER_FOR_CELL;
          doRepaint = true;

          if (field[(cRow * N_COLS) + cCol] == MINE_CELL) {
            inGame = false;
          }

          if (field[(cRow * N_COLS) + cCol] == EMPTY_CELL) {
            find_empty_cells((cRow * N_COLS) + cCol);
          }
        }
      }
    }
  }

  public Board(App a) {
    super(a);
  }
}
