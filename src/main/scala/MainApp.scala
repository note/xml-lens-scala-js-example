import org.scalajs.dom.document
import pl.msitko.xml.dsl._
import pl.msitko.xml.parsing.XmlParser
import pl.msitko.xml.printing.XmlPrinter

import scala.scalajs.js.JSApp


/** To run:
  * fastOptJS::webpack
  * then open `target/scala-2.12/classes/index-dev.html`
  */
object MainApp extends JSApp {

  def main(): Unit = {
    println("Starting scala.js app ...")

    // some XML input
    val input =
      """<?xml version="1.0" encoding="UTF-8"?>
        |<a>
        |  <e>item</e>
        |  <f>item</f>
        |  <g>item</g>
        |</a>""".stripMargin

    // turn `f` node to upper case - define transformation
    val modify = (root \ "f").hasTextOnly.modify(_.toUpperCase)

    // parse XML
    val parsed = XmlParser.parse(input).right.get

    // apply transformation
    val res = modify(parsed)

    val resAsString = XmlPrinter.print(res)

    val textarea = {
      val elem = document.createElement("textarea")
      val text = document.createTextNode(resAsString)
      elem.appendChild(text)
      elem
    }
    document.body.appendChild(textarea)

  }

}
