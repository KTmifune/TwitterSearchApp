package cowma.katotama.twittersearchapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TwitterListAdapter(context:Context, private val mTwitterList: List<TweetModel>):
    ArrayAdapter<TweetModel>(context, 0, mTwitterList) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Modelの取得
        val model = mTwitterList[position]

        // レイアウトの設定
        val view = convertView ?: layoutInflater.inflate(R.layout.twitter_layout, parent, false)

        // 各Viewの設定
        val imageView = view?.findViewById<ImageView>(R.id.icon_image)
        imageView?.setImageBitmap(model.profileImage)

        val name = view?.findViewById<TextView>(R.id.username_text)
        name?.text = model.userName

        val age = view?.findViewById<TextView>(R.id.comment_text)
        age?.text = model.tweetText

        return view!!
    }
    // リスト表示するデータ件数
    override fun getCount() = mTwitterList.size
}