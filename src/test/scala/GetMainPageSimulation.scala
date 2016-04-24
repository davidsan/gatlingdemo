import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GetMainPageSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://wp-davidsan.rhcloud.com/")
    .acceptHeader("text/html")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116")
    .acceptLanguageHeader("en-US,en;q=0.8,pt;q=0.6")

  val scn = scenario("Get main page")
    .exec(
      http("getMainPage")
        .get("/")
        .check(status.is(_ => 200))
    )
    .pause(1)

  setUp(
		scn.inject(
			constantUsersPerSec(50) during(10 seconds)
			).protocols(httpConf)
		)
}
