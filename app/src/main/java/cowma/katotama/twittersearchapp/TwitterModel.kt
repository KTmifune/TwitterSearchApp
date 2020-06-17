package cowma.katotama.twittersearchapp

import android.graphics.Bitmap

data class TwitterModel(
    val userName : String,
    val comment:String,
    val iconImage : Bitmap
)