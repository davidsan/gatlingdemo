name := "wp-load-test"
version := "0.1.0"

scalaVersion := "2.11.8"

enablePlugins(GatlingPlugin)

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0" % "test"
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.2.0" % "test"
