package com.ankangban.health.features.sleep.tools

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import kotlinx.coroutines.*
import java.util.Random

class WhiteNoisePlayer {

    private var audioTrack: AudioTrack? = null
    private var isPlaying = false
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.IO)

    enum class NoiseType {
        WHITE, PINK, BROWN
    }

    fun play(type: NoiseType) {
        stop()
        isPlaying = true
        
        val sampleRate = 44100
        val minBufferSize = AudioTrack.getMinBufferSize(
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )

        audioTrack = AudioTrack(
            AudioManager.STREAM_MUSIC,
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            minBufferSize * 2,
            AudioTrack.MODE_STREAM
        )

        audioTrack?.play()

        job = scope.launch {
            val bufferSize = minBufferSize
            val buffer = ShortArray(bufferSize)
            val random = Random()
            
            // State variables for Pink/Brown noise
            var b0 = 0.0
            var b1 = 0.0
            var b2 = 0.0
            var b3 = 0.0
            var b4 = 0.0
            var b5 = 0.0
            var b6 = 0.0
            var brownVal = 0.0

            while (isActive && isPlaying) {
                for (i in 0 until bufferSize) {
                    val white = random.nextDouble() * 2 - 1
                    var output = 0.0

                    when (type) {
                        NoiseType.WHITE -> {
                            output = white
                        }
                        NoiseType.PINK -> {
                            // Paul Kellet's refined method
                            b0 = 0.99886 * b0 + white * 0.0555179
                            b1 = 0.99332 * b1 + white * 0.0750759
                            b2 = 0.96900 * b2 + white * 0.1538520
                            b3 = 0.86650 * b3 + white * 0.3104856
                            b4 = 0.55000 * b4 + white * 0.5329522
                            b5 = -0.7616 * b5 - white * 0.0168980
                            output = b0 + b1 + b2 + b3 + b4 + b5 + b6 + white * 0.5362
                            output *= 0.11 // Normalize roughly
                            b6 = white * 0.115926
                        }
                        NoiseType.BROWN -> {
                            // Integrate white noise
                            brownVal = (brownVal + (0.02 * white)) / 1.02
                            output = brownVal * 3.5 // Gain
                        }
                    }

                    // Hard clip to prevent overflow
                    if (output > 1.0) output = 1.0
                    if (output < -1.0) output = -1.0
                    
                    buffer[i] = (output * Short.MAX_VALUE).toInt().toShort()
                }
                
                try {
                    audioTrack?.write(buffer, 0, bufferSize)
                } catch (e: Exception) {
                    break
                }
            }
        }
    }

    fun stop() {
        isPlaying = false
        job?.cancel()
        try {
            audioTrack?.stop()
            audioTrack?.release()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        audioTrack = null
    }
}