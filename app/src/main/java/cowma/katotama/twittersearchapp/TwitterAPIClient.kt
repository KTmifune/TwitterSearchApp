package cowma.katotama.twittersearchapp

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL


class TwitterAPIClient(private val context: Context, val listView: ListView)  {
    private val tag = "TwitterAPIClient"

    suspend fun twitterGetTask(vararg keyword: String) {
        try {

            val tweetList<>
            val url = "https://api.twitter.com/1.1/search/tweets.json?q=${keyword[0]}&lang=ja"
            val http = HttpUtil()

            // onPreExecute
            withContext(Dispatchers.Main) {
                Toast.makeText(context,"start : $keyword",Toast.LENGTH_SHORT).show()
            }

            // API
            val response = http.httpGet(url)
            // Json
            val jsonObj = JSONObject(response)
            // Get json List
            val dataList = jsonObj.getJSONArray("statuses")

            //
//            Log.d(tag,"data->$dataList")
//            Log.d(tag,"data.length${dataList.length()}")

            for (i in 0 until dataList.length()) {
                val data = dataList.getJSONObject(i)
                // get name
                val name = data.getJSONObject("user").getString("name")
                // get text
                val text = data.getString("text")

                val imageUrlHttps = data.getJSONObject("user").getString("profile_image_url_https")

                Log.d(tag,"Name:$name Text:$text URl:$imageUrlHttps\n")

                //Get image bitmap
                val imageUrl = URL(imageUrlHttps)
                val imageIs = imageUrl.openStream()
                val iconImage = BitmapFactory.decodeStream(imageIs)



            }

            // onPostExecuteメソッド
//            withContext(Dispatchers.Main) {
//                Toast.makeText(context,"finish",Toast.LENGTH_SHORT).show()
//            }
        } catch (e: Exception) {
            // onCancelledメソッド
            Log.e(tag, "Error In TwitterAPIClient", e)
        }
    }
}