name := "uma-math-presentation"

version := "0.1"

scalaVersion := "2.12.12"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.3"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3"

libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.8"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5"


libraryDependencies += "org.apache.poi" % "poi" % "5.0.0"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.0.0"