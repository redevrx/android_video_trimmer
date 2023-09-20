package com.redevrx.android_video_trimmer

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.redevrx.android_video_trimmer.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), OnVideoEditedEvent {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        val uri = intent.extras?.get("image") as Uri?
        val path =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        binding.videoTrimmer.apply {
            setVideoBackgroundColor(resources.getColor(R.color.white))
            setOnTrimVideoListener(this@MainActivity2)
            setVideoURI(uri!!)
            setDestinationPath(path.absolutePath)
            setVideoInformationVisibility(true)
            setMaxDuration(30)
            setMinDuration(0)
            setOnClickListener {
                saveVideo()
            }
        }
    }


    override fun getResult(uri: Uri) {
        println("Save video success")
        println(uri.path)
    }


    override fun onError(message: String) {
        println("Save video error :$message")
    }

    override fun onProgress(percentage: Int) {

    }

}