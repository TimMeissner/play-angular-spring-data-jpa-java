name := """playintro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"


libraryDependencies ++= Seq(
  javaCore,
  javaJpa,
  "org.springframework" % "spring-context" % "4.1.6.RELEASE",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.data" % "spring-data-jpa" % "1.8.0.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)




fork in run := true