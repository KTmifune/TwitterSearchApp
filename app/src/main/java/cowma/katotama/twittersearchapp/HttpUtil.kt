package cowma.katotama.twittersearchapp

import okhttp3.OkHttpClient
import okhttp3.Request

object HttpClient {
    //OKHttp3はシングルトンで使う
    val instance = OkHttpClient()
}
class HttpUtil {
    fun httpGet(url : String): String? {
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer " + "AAAAAAAAAAAAAAAAAAAAAH3R4wAAAAAALVF%2Bx1z1rUxYdYBSeZdlp4Z3hq8%3DrgLBJ2WxFA0RUhr8XI2jVNUK3Cmvn8d1MB71jjnEMcwduzi4T6")
            .build()

        val response = HttpClient.instance.newCall(request).execute()
        return response.body?.string()
    }
}