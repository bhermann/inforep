package de.thewhitespace.inforep.audio

import javax.sound.sampled.{AudioSystem, AudioFormat, SourceDataLine}

/**
 * Created by benhermann on 22/10/15.
 */
object GenerationTest {
  def main(args: Array[String]) {
    val af : AudioFormat = new AudioFormat( (44100).toFloat, 8, 1, true, false )
    var sdl : SourceDataLine = AudioSystem.getSourceDataLine( af )
    sdl.open()
    sdl.start()

    val freq = 600
    val length = 500.0

    pushTone(sdl, 600, 500.0)
    pushSilence(sdl, 50.0)
    pushTone(sdl, 600, 250.0)
    pushSilence(sdl, 50.0)
    pushTone(sdl, 600, 250.0)
    pushSilence(sdl, 50.0)
    pushTone(sdl, 600, 250.0)
    pushSilence(sdl, 50.0)
    pushTone(sdl, 600, 500.0)
    pushSilence(sdl, 50.0)

    sdl.drain()
    sdl.stop()
  }

  def pushTone(sdl: SourceDataLine, freq: Int, length: Double): Unit = {
    var buf: Array[Byte] = Array[Byte](1)
    for (i <- 0 to (length * 44100.0 / 1000.0).toInt) {
      val angle: Double = i / ((44100).toFloat / freq) * 2.0 * Math.PI
      buf(0) = (Math.sin(angle) * 100).toByte
      sdl.write(buf, 0, 1)
    }
  }

  def pushSilence(sdl: SourceDataLine, length: Double): Unit = {
    var buf: Array[Byte] = Array[Byte](1)
    for (i <- 0 to (length * 44100.0 / 1000.0).toInt) {
      buf(0) = 0
      sdl.write(buf, 0, 1)
    }
  }
}


