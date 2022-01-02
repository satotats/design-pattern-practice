package satotats.practice.designpattern.flyweight

import java.io.{BufferedReader, FileReader}
import scala.collection.mutable

/** 「増補改訂版Java言語で学ぶデザインパターン入門」(2004, 結城浩) の
 * Flyweight pattern実装のscala版(諸般の都合で一部改変) */

class BigChar(private val charName: Char) {
  private val fontData = BigCharLibrary.get(charName.toLower)

  def print = println(fontData)
}

object BigCharFactory {
  private val map = mutable.HashMap[Char, BigChar]()

  def getBigChar(char: Char) = map.getOrElseUpdate(char, BigChar(char))
}

class BigString(val string: String) {
  private val chars = string.toCharArray.map(BigCharFactory.getBigChar)

  def print() = chars.foreach(_.print)
}

object BigCharLibrary {
  def get(char: Char) = map.getOrElse(char, "")

  private val H =
    """■        ■
      |■        ■
      |■■■■■■■■■■
      |■        ■
      |■        ■
      |""".stripMargin

  private val E =
    """■■■■■■■■■■
      |■
      |■■■■■■■■■■
      |■
      |■■■■■■■■■■
      |""".stripMargin

  private val L =
    """■
      |■
      |■
      |■
      |■■■■■■■■■■
      |""".stripMargin

  private val O =
    """■■■■■■■■■■
      |■        ■
      |■        ■
      |■        ■
      |■■■■■■■■■■
      |""".stripMargin

  private val map = Map(
    'h' -> H,
    'e' -> E,
    'l' -> L,
    'o' -> O
  )
}

@main def main = BigString("Hello").print()