# Chess Data Analyzer

This project processes chess game data from a CSV file and answers two main questions:

1. **Which player pairs (White vs Black) have played against each other more than 5 times?**
2. **Which are the top 5 most common moves across all games?**

The program is written in **Scala** and reads input from a CSV file containing chess games.

---

## 📂 Project Structure

├── input/
│ └── games.csv # Input CSV file with chess games
├── src/
│ └── chessData.scala # Main source code

---

## ⚙️ Requirements

- **Scala** (2.13.x or 3.x)
- **Java** (JDK 8+)

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/chess-data-analyzer.git
   cd chess-data-analyzer
Place your input file at:
input/games.csv
The file must contain at least the following columns (comma-separated):

Column 8: White Player ID

Column 10: Black Player ID

Column 12: List of moves (space-separated)

Compile and run:
scalac src/chessData.scala
scala chessData
📝 Notes

The program ignores the first line of the CSV (assumed to be headers).

Player IDs are sorted alphabetically per game to treat (A,B) and (B,A) as the same pair.

Moves are split by spaces and counted globally.

📌 Future Improvements

Add support for command-line arguments (e.g., input file path, thresholds).

Export results to a file instead of console output.

Extend analysis to include game results or openings.
