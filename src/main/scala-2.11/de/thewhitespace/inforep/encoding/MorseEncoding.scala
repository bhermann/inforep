package de.thewhitespace.inforep.encoding

/**
 * Created by benhermann on 22/10/15.
 */
class MorseEncoding extends Encoder {

  abstract class MorseTone

  case class Tone(internalValue: Int, stringRep: String, length: Int) extends MorseTone {
    override def toString(): String = stringRep
  }

  val Short = Tone(0, ".", 1)
  val Long = Tone(1, "-", 3)
  val LetterSpace = Tone(2, " ", 3)
  val WordSpace = Tone(3, "  ", 4)

  // 4 + 3 ==> 7

  class MorseChunk(tones: MorseTone*) extends Chunk {
    override def toString(): String = {
      tones.mkString("") + LetterSpace.toString()
    }

  }

  override def encode(input: String): Seq[Chunk] = {
    input.toCharArray.map(encode)
  }

  def encode(c: Char): Chunk = c.toUpper match {
    case 'A' => new MorseChunk(Short, Long)
    case 'B' => new MorseChunk(Long, Short, Short, Short)
    case 'C' => new MorseChunk(Long, Short, Long, Short)
    case 'D' => new MorseChunk(Long, Short, Short)
    case 'E' => new MorseChunk(Short)
    case 'F' => new MorseChunk(Short, Short, Long, Short)
    case 'G' => new MorseChunk(Long, Long, Short)
    case 'H' => new MorseChunk(Short, Short, Short, Short)
    case 'I' => new MorseChunk(Short, Short)
    case 'J' => new MorseChunk(Short, Long, Long, Long)
    case 'K' => new MorseChunk(Long, Short, Long)
    case 'L' => new MorseChunk(Short, Long, Short, Short)
    case 'M' => new MorseChunk(Long, Long)
    case 'N' => new MorseChunk(Long, Short)
    case 'O' => new MorseChunk(Long, Long, Long)
    case 'P' => new MorseChunk(Short, Long, Long, Short)
    case 'Q' => new MorseChunk(Long, Long, Short, Long)
    case 'R' => new MorseChunk(Short, Long, Short)
    case 'S' => new MorseChunk(Short, Short, Short)
    case 'T' => new MorseChunk(Long)
    case 'U' => new MorseChunk(Short, Short, Long)
    case 'V' => new MorseChunk(Short, Short, Short, Long)
    case 'W' => new MorseChunk(Short, Long, Long)
    case 'X' => new MorseChunk(Long, Short, Short, Long)
    case 'Y' => new MorseChunk(Long, Short, Long, Long)
    case 'Z' => new MorseChunk(Long, Long, Short, Short)

    case '1' => new MorseChunk(Short, Long, Long, Long, Long)
    case '2' => new MorseChunk(Short, Short, Long, Long, Long)
    case '3' => new MorseChunk(Short, Short, Short, Long, Long)
    case '4' => new MorseChunk(Short, Short, Short, Short, Long)
    case '5' => new MorseChunk(Short, Short, Short, Short, Short)
    case '6' => new MorseChunk(Long, Short, Short, Short, Short)
    case '7' => new MorseChunk(Long, Long, Short, Short, Short)
    case '8' => new MorseChunk(Long, Long, Long, Short, Short)
    case '9' => new MorseChunk(Long, Long, Long, Long, Short)
    case '0' => new MorseChunk(Long, Long, Long, Long, Long)

    case ' ' => new MorseChunk(WordSpace)
  }


}
