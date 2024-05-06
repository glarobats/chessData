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

    // Διαπέραση του αρχείου
    while (scanner.hasNextLine) {
      // Διαπέραση της κάθε γραμμής
      val line = scanner.nextLine()

      // Χωρισμός της γραμμής σε πεδία
      val data = line.split(",")

      /**********************************************************/
      // Α' ερώτημα

      // Ταξινόμηση των πεδίων 8 και 10 αλφαβητικά
      val sortedData = Array(data(8), data(10)).sorted

      // Σχηματισμός του ζευγαριού παικτών
      val playerPair = sortedData(0) + "_" + sortedData(1)

      // Αύξηση της μετρητή για το ζευγάρι παικτών
      playerPairsCount += (playerPair -> (playerPairsCount.getOrElse(playerPair, 0) + 1))

      /**********************************************************/
      // Β' ερώτημα

    }
    // Α' ερώτημα
    // Εύρεση των ζευγαριών παικτών που έχουν παιχτεί πάνω από 5 φορές
    val frequentPlayerPairs = playerPairsCount.filter(_._2 > 5)






    // Α' ερώτημα
    // Εκτύπωση των αποτελεσμάτων
    frequentPlayerPairs.foreach { case (pair, count) =>
      println(pair + "," + count)
    }

    // Κλείσιμο του αρχείου
    scanner.close()
  }
}
