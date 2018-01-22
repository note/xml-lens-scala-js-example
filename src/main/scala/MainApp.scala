import scala.scalajs.js.JSApp

import org.scalajs.dom
import dom.{ document, window }

import net.michalsitko.xml.parsing.XmlParser

object MainApp extends JSApp {

  def main(): Unit = {
    println("Starting 'my-scala-js'...")

    val p = document.createElement("p")
    val text = document.createTextNode("Hello!")
    p.appendChild(text)
    document.body.appendChild(p)


    val input = "<a></a>"
    val res = XmlParser.parse(input)
    println("bazinga here: " + res)

    
    /*import moment._

    Moment.locale("en_GB")

    val millis = 1516559497702L
    Moment().calendar()
    Moment(millis).calendar()
    Moment(millis).fromNow()*/
  }

}
