name := "scala-camel"

version := "1.0"

libraryDependencies ++= {
  Seq(
    "org.apache.camel" % "camel-core"   % "2.14.0",
    "org.apache.camel" % "camel-test"   % "2.14.0",
    "org.apache.camel" % "camel-ftp"    % "2.14.0",
    "org.apache.camel" % "camel-aws"    % "2.14.0",
    "org.slf4j"        % "slf4j-simple" % "1.7.7",
    "log4j"            % "log4j"        % "1.2.17"
  )
}

    