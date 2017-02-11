name := "scala-project-skeleton"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "3.0.0" % Test,
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5"
  )

parallelExecution in Test := false
