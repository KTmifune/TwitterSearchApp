package cowma.katotama.twittersearchapp

import android.content.Context
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TwitterAPIClient(private val context: Context, val listView: ListView)  {
    private val tag = "TwitterAPIClient"

    suspend fun twitterGetTask(vararg keyword: String) {
        try {

            val url = "https://api.twitter.com/1.1/search/tweets.json?q=$keyword&lang=ja"
            val http = HttpUtil()

            // onPreExecute
            withContext(Dispatchers.Main) {
                Toast.makeText(context,"start : $keyword",Toast.LENGTH_SHORT).show()
            }

            // doInBackgroundメソッド
            val response = http.httpGet(url)

            Log.e(tag,"response$response")

            //val result = http.httpGet(uri)

            // onPostExecuteメソッド
            withContext(Dispatchers.Main) {
                Toast.makeText(context,"finish",Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            // onCancelledメソッド
            Log.e(tag, "Cancel", e)
        }
    }
}