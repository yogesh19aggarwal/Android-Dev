package com.example.day30mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day30mediaplayer.databinding.ActivityMainBinding
import android.os.Handler

class MainActivity : AppCompatActivity() {

    lateinit var mediaPlayer : MediaPlayer
    var totalTime : Int = 0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.music1)
        mediaPlayer.setVolume(1f, 1f)
        totalTime = mediaPlayer.duration

        var btnPlay = binding.play
        var btnPause = binding.pause
        var btnStop = binding.stop
        var seekbar = binding.seekBar

        btnPlay.setOnClickListener {
            mediaPlayer.start()
        }

        btnPause.setOnClickListener {
            mediaPlayer.pause()
        }
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
        }


        seekbar.max = totalTime
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        val handler = Handler()
        handler.postDelayed(object : Runnable{
            override fun run() {
                try {
                    seekbar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch(exception : Exception){
                    seekbar.progress = 0
                }
            }

        },0)
    }
}