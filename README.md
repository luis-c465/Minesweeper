# Minesweeper

Minesweeper game for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/Seating/releases/latest)**
- Then run in the command line _(Or just double click on the file)_
  ```bash
  java -jar [path to downloaded jar file]
  ```

## Building

### Dependencies

- **[Maven v3.8.4](https://maven.apache.org/download.cgi)**

### How to build

Run the following in the [command line](https://www.freecodecamp.org/news/how-to-use-the-cli-beginner-guide/#how-to-locate-your-cli)

```bash
mvn clean compile assembly:single
```

- Then the **Executable Jar** `minesweeper.jar` will be in the root folder 🎉

## Project Requirements

Due: **Mon, Feb 21 2023** @1 AM

- Exit button.
- Mine placement is randomized
- Die when you find a mine
- Counts how many moves you have made
- Easy/Medium/Hard mode changes the number of mines present
- Unlocking a tile shows how many mines that tile is touching.
- Counts how many times you’ve won/lost.
