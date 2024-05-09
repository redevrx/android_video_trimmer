# Android Video Trimmer
Create Video Trimmer with Media3

## Setup

### Kotlin-dsl
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
    }
}
```

### Gradle groovy
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```groovy
implementation 'com.github.redevrx:android_video_trimmer:1.0.1'
```

## Example
```xml
 <com.redevrx.video_trimmer.view.VideoEditor
        android:id="@+id/video_trimmer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

```kotlin
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
```

## Example App
<img src="example.gif" width="350"  alt="Example Video App"/>


