name := "chalk"

version := "1.1.3-SNAPSHOT"

organization := "org.scalanlp"

scalaVersion := "2.10.1"

crossPaths := false

retrieveManaged := true

resolvers ++= Seq(
  "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"
)

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://scalanlp.org/</url>
  <licenses>
    <license>
      <name>Apache License 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:scalanlp/chalk.git</url>
    <connection>scm:git:git@github.com:scalanlp/chalk.git</connection>
  </scm>
  <developers>
    <developer>
      <id>jasonbaldridge</id>
      <name>Jason Baldridge</name>
      <url>http://www.jasonbaldridge.com</url>
    </developer>
  </developers>
)