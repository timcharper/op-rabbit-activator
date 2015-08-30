import scalariform.formatter.preferences._

name := "op-rabbit"

version := "1.1"

scalaVersion := "2.11.7"

resolvers += "SpinGo OSS" at "http://spingo-oss.s3.amazonaws.com/repositories/releases"

libraryDependencies ++= Seq(
  "com.spingo" %% "op-rabbit" % "1.0.0-RC1"
)

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)

fork in run := true
