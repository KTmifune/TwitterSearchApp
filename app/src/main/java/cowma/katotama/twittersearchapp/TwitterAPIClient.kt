package cowma.katotama.twittersearchapp

import android.content.Context
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TwitterAPIClient(private val context: Context, val listView: ListView)  {
    private val tag = "TwitterAPIClient"

    private suspend fun ApiTask(vararg keyword: String) {
        try {

            // onPreExecute
            withContext(Dispatchers.Main) {
                Toast.makeText(context,"start",Toast.LENGTH_SHORT).show()
            }

            // doInBackgroundメソッド

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