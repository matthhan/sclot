import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.0.1"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )
