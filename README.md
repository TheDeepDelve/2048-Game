# 2048 Game (Java)

A desktop implementation of the classic 2048 puzzle game, built in Java using Swing and AWT for a smooth and responsive user interface.

---

## Table of Contents
- [About](#about)
- [Features](#features)
- [Demo](#demo)
- [Installation](#installation)
- [Usage](#usage)
- [Game Rules](#game-rules)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [Contact](#contact)

---

## About
2048 Game is a single-player sliding block puzzle game. This Java version recreates the addictive experience of the original, with a modern UI, smooth animations, and persistent high scores.

## Features
- **Classic 2048 Gameplay:** Move and merge tiles on a 4x4 grid to reach 2048.
- **Responsive UI:** Built with Java Swing and AWT, featuring custom painting for fast rendering.
- **Image Tiles:** Uses custom tile images for a visually appealing experience.
- **High Score Tracking:** Automatically saves and displays your best score.
- **Efficient Performance:** Optimized input handling and rendering for minimal response time (<50 ms).
- **Keyboard Controls:** Use arrow keys to play.
- **Persistent High Score:** High scores are saved between sessions.
- **Lightweight:** No external dependencies required.

## Demo
![Game Screenshot](Interfaces/Picture1.jpg)

---

## Installation
1. **Clone or Download** this repository:
   ```
   git clone https://github.com/yourusername/java-2048.git
   ```
2. **Compile the Source:**
   - Open a terminal in the project directory.
   - Run:
     ```
     javac -d bin src/Main.java src/game/*.java
     ```
3. **Run the Game:**
   - From the project directory, run:
     ```
     java -cp bin Main
     ```

## Usage
- Launch the game as described above.
- Use the arrow keys to move the tiles.
- Try to combine tiles to reach the 2048 tile!
- Your best score will be saved automatically.

## Game Rules
- Use the arrow keys to slide all tiles in one direction.
- When two tiles with the same number touch, they merge into one.
- After every move, a new tile (2 or 4) appears in a random empty spot.
- The game is over when no moves are possible.

## Project Structure
```
src/
  Main.java           # Entry point
  game/
    Game.java         # Game logic
    GameState.java    # State management
    GUI.java          # User interface
    Java2048.java     # Main game class
res/
  img/                # Tile images
  highscore.txt       # High score storage
Interfaces/           # Screenshots and UI images
```

## Tech Stack
- Java 8+
- Java Swing (UI)
- Java AWT (Graphics)
- Java Collections Framework


## FAQ
**Q: Can I play with a different grid size?**  
A: This version supports only the classic 4x4 grid.

**Q: How is the high score saved?**  
A: The high score is stored in `res/highscore.txt` and loaded automatically.

**Q: Can I use this code for my own project?**  
A: Yes, but please provide attribution.

## Screenshots
![Game Screenshot](Interfaces/Picture1.jpg)

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

To contribute:
1. **Fork the Project**
2. **Create your Feature Branch**
    ```bash
    git checkout -b feature/AmazingFeature
    ```
3. **Commit your Changes**
    ```bash
    git commit -m 'Add some AmazingFeature'
    ```
4. **Push to the Branch**
    ```bash
    git push origin feature/AmazingFeature
    ```
5. **Open a Pull Request**

Feel free to open issues for bugs, suggestions, or questions. We appreciate your help in making the 2048 Game better!

---

## Contact

Harsh Deep - [LinkedIn](https://www.linkedin.com/in/harshdeep7199/) - [Email](harshdeep7199@gmail.com)
