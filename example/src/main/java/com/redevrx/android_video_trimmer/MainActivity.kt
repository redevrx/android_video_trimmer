package com.redevrx.android_video_trimmer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.redevrx.android_video_trimmer.databinding.ActivityMainBinding
import com.redevrx.video_trimmer.view.VideoEditor


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var videoEditor: VideoEditor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding = ActivityMainBinding.inflate(layoutInflater)


        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        println("download path")
        println(path)

        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "Select Video"),
            11
        )

//        binding.videoTrimmer.apply {
//            setOnTrimVideoListener(this@MainActivity)
//            setOnVideoListener(this@MainActivity)
//            setVideoURI(pathFile.orEmpty().toUri())
//            setVideoInformationVisibility(true)
//            setMaxDuration(10)
//            setMinDuration(2)
//            setVideoQuality(VideoQuality.VeryHigh) // set video quality
//            setOnClickListener {
//             ///   onSaveClicked()
//            }
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode === RESULT_OK) {
            if (requestCode === 11) {
                val selectedImageUri: Uri? = data?.data

                if (selectedImageUri == null) return
                val mIntent = Intent(this, MainActivity2::class.java)
                mIntent.putExtra("image", selectedImageUri)
                startActivity(mIntent)
            }
        }

    }
}
