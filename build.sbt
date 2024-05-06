name := "chessData"

version := "1.0"

scalaVersion := "2.12.14" // or whichever version you're using

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.3",
  "org.apache.spark" %% "spark-sql" % "3.3.3" // Add more dependencies if necessary
)