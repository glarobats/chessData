import java.io.File
import java.util.Scanner

object chessData {
  def main(args: Array[String]): Unit = {

    // Αρχείο εισόδου
    val filePath = "input/games.csv"

    // Άνοιγμα του αρχείου
    val file = new File(filePath)
    val scanner = new Scanner(file)

    // Παράβλεψη της πρώτης γραμμής
    if (scanner.hasNextLine) {
      scanner.nextLine()
    }

    // Μεταβλητή για αποθήκευση των ζευγαριών παικτών και των εμφανίσεών τους
    var playerPairsCount = Map.empty[String, Int]

    // Μεταβλητή για αποθήκευση των κινήσεων και των εμφανίσεών τους
    var moves = Map.empty[String, Int]

    // Διαπέραση του αρχείου
    while (scanner.hasNextLine) {
      // Διαπέραση της κάθε γραμμής
      val line = scanner.nextLine()

      // Χωρισμός της γραμμής σε πεδία
      val data = line.split(",")

      /**********************************************************/
      // Α' ερώτημα

      /* Ταξινόμηση των πεδίων 8 (white player ID) και 10 (black player ID) αλφαβητικά (η ταξινόμηση γίνεται ανα γραμμή) ώστε π.χ. το ζευγάς Α,Β και το
      ζεύγος Β,Α που είναι ίδια, να αναπαρασταθούν ως Α,Β */
      val sortedData = Array(data(8), data(10)).sorted

      // Σχηματισμός του ζευγαριού παικτών
      val playerPair = sortedData(0) + "_" + sortedData(1)

      // Αύξηση της μετρητή για το ζευγάρι παικτών
      playerPairsCount += (playerPair -> (playerPairsCount.getOrElse(playerPair, 0) + 1))

      /**********************************************************/
      // Β' ερώτημα

      // Αποθήκευση των κινήσεων σε πίνακα
      val movesPerLine = data(12).split(" ")

      // Διαπέραση του array και αύξηση της μετρητή για κάθε κίνηση
      for (move <- movesPerLine) {
        moves += (move -> (moves.getOrElse(move, 0) + 1))
      }
    }// Τέλος while loop

    // Α' ερώτημα
    // Εύρεση των ζευγαριών παικτών που έχουν παιχτεί πάνω από 5 φορές
    val frequentPlayerPairs = playerPairsCount.filter(_._2 > 5)

    // Εκτύπωση των αποτελεσμάτων
    println("Ερώτημα Α'\n")
    frequentPlayerPairs.foreach { case (pair, count) =>
      println(pair + "," + count)
    }

    // Β' ερώτημα
    // Εύρεση των 5 πιο κοινών κινήσεων
    val top5Moves = moves.toList.sortBy(-_._2).take(5)

    // Εκτύπωση των 5 πιο κοινών κινήσεων
    println("\n\nΕρώτημα B'\n")
    println("Οι 5 πιο κοινές κινήσεις:")
    top5Moves.foreach { case (move, count) =>
      println(s"$move,$count")
    }

    // Κλείσιμο του Scanner
    scanner.close()
  }
}
