version in ThisBuild := "0.0.3-SNAPSHOT"

val rxjsVersion = "5.0.1"
val smacrotoolsVersion = "0.0.5"

organization in ThisBuild := "de.surfice"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  libraryDependencies ++= Seq(
    "de.surfice" %%% "smacrotools-sjs" % smacrotoolsVersion % "provided",
    "com.lihaoyi" %%% "utest" % "0.4.4" % "test"
  ),
  scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = baseDirectory.value.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/jokade/scalajs-rxjs"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      })),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
)

lazy val crossSettings = Seq(
  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.11.8","2.12.1")
)

lazy val rxjs = project.in(file("."))
  .aggregate(global,cjsm)
  .settings(crossSettings:_*)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val global = project
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings: _*)
  .settings(crossSettings:_*)
  .settings(publishingSettings: _*)
  .settings( 
    name := "scalajs-rxjs",
    scalaSource in Compile := baseDirectory.value / ".." / "shared" / "src" / "main" / "scala",
    scalaSource in Test := baseDirectory.value / ".." / "shared" / "src" / "test" / "scala",
    libraryDependencies ++= Seq(
    ),
    jsDependencies ++= Seq(
      "org.webjars.npm" % "rxjs" % rxjsVersion / "bundles/Rx.js" commonJSName "Rx"
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    resolvers += Resolver.sonatypeRepo("releases")
  )

lazy val cjsm = project
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings: _*)
  .settings(crossSettings:_*)
  .settings(publishingSettings: _*)
  .settings(
    name := "scalajs-rxjs_cjsm",
    scalaSource in Compile := baseDirectory.value / ".." / "shared" / "src" / "main" / "scala",
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    scalacOptions += "-Xmacro-settings:smacrotools.jsref=cjsm"
  )


lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/scalajs-rxjs</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/scalajs-rxjs</url>
      <connection>scm:git:git@github.com:jokade/scalajs-rxjs.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
