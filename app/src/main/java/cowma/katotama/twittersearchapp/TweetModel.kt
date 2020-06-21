package cowma.katotama.twittersearchapp

import android.graphics.Bitmap

//TwitterAPIから取得したデータを格納するモデル
data class TweetModel(
    val userName : String,
    val comment:String,
    val iconImage : Bitmap
)