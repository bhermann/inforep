package de.thewhitespace.inforep.encoding

/**
 * Created by benhermann on 25.10.15.
 */
object MorseCheck {
  def main(args: Array[String]): Unit = {
    println(new MorseEncoding().encode("Hallo 112").mkString(""))
  }
}
