package cowma.katotama.twittersearchapp

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ListView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

// TwitterAPIを使用したHttp通信実行クラス
class TwitterAPIClient(private val context: Context, private val listView: ListView)  {
    private val tag = "TwitterAPIClient"

    suspend fun twitterGetTask(vararg keyword: String) {
        try {

            val tweetList = mutableListOf<TweetModel>()
            val url = "https://api.twitter.com/1.1/search/tweets.json?q=${keyword[0]}&lang=ja"
            val http = HttpUtil()

            // HttpGETでJson取得
            val response = http.httpGet(url)
            // 配列化
            val jsonObj = JSONObject(response)
            val dataList = jsonObj.getJSONArray("statuses")

            //Json配列から名前、ツイート内容、プロフィール画像のURLを取得してListに追加する
            for (i in 0 until dataList.length()) {
                val data = dataList.getJSONObject(i)
                val name = data.getJSONObject("user").getString("name")
                val text = data.getString("text")

                val imageUrlHttps = data.getJSONObject("user").getString("profile_image_url_https")

                //取得したプロフィールの画像URLからビットマップを取得する
                val imageUrl = URL(imageUrlHttps)
                val imageIs = imageUrl.openStream()
                val iconImage = BitmapFactory.decodeStream(imageIs)

                //TweetModelに各要素をつめて、Listに追加
                tweetList.add(TweetModel(userName = name,tweetText = text, profileImage = iconImage))
            }

            // Mainスレッドに切り替えてListViewを設定する
            withContext(Dispatchers.Main) {
                Log.d(tag,"tweetList:$tweetList")

                val adapter = TwitterListAdapter(context = context,mTwitterList = tweetList)
                listView.adapter = adapter
            }
        } catch (e: Exception) {
            // エラー処理
            Log.e(tag, "Error In TwitterAPIClient", e)
        }
    }
}