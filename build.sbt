name := "fp-in-scala"

version := "1.0"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

parallelExecution in Test := false

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

mainClass in (Compile, run) := Some("com.banno.kevin.fpinscala.Chapter1")
