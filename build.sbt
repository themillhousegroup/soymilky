import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "soymilky"

version := "0.1.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-feature", "-language:implicitConversions")

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.1",
  "org.json4s" %% "json4s-jackson" % "3.2.10",
  "org.scala-lang" %% "scala-pickling" % "0.8.0",
  "org.slf4j" % "slf4j-nop" % "1.7.7",
  "org.twitter4j" % "twitter4j-stream" % "3.0.3",
  "org.specs2" %% "specs2" % "2.4.1-scalaz-7.0.6" % "test"
)

initialCommands in console := """
  import soymilky._
  import soymilky.Configuration._
  import twitter4j._
"""

// Get the SBT Native Packager to build us a start script
// so we don't need SBT on our target box:
packageArchetype.java_application

// Include the path to a local ../conf directory so account.config can be sourced: 
scriptClasspath += "../conf"
