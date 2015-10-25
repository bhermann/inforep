package de.thewhitespace.inforep.encoding

/**
 * Created by benhermann on 25.10.15.
 */
trait Encoder {
  def encode(input: String): Seq[Chunk]
}
