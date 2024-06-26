name         := "uma-math-presentation"
version      := "0.1"
scalaVersion := "2.13.12"

libraryDependencies += "org.apache.spark" %% "spark-core"           % "3.5.0"
libraryDependencies += "org.apache.spark" %% "spark-sql"            % "3.5.0"
libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "3.5.1"
libraryDependencies += "org.postgresql"    % "postgresql"           % "42.2.5"
libraryDependencies += "org.apache.poi"    % "poi"                  % "5.0.0"
libraryDependencies += "org.apache.poi"    % "poi-ooxml"            % "5.0.0"
libraryDependencies += "org.typelevel"    %% "cats-core"            % "2.12.0"

addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
addCompilerPlugin("com.olegpy"   %% "better-monadic-for" % "0.3.1")
