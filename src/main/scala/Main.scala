import org.apache.camel.main.{ Main => CamelMain }
import org.apache.camel.builder.RouteBuilder

object Main extends App {

  val m = new CamelMain()

  m.addRouteBuilder(new RouteBuilder() {
    override def configure(): Unit = {
      from("ftp://vagrant@192.168.33.25/devlocal/input/?password=vagrant&delete=true")
        .to("log:rightster.file?level=INFO")
        .to("file:input")

      from("file:input?delete=true")
        .streamCaching()
        .setHeader("CamelAwsS3ContentLength", header("CamelFileLength"))
        .setHeader("CamelAwsS3Key", header("CamelFileName"))
        .to("log:rightster.in-bound?level=INFO")
        .to("aws-s3://javi-test-bucket?accessKey=XXXX&secretKey=XXXX=eu-west-1")
    }
  })

  m.run()
}
