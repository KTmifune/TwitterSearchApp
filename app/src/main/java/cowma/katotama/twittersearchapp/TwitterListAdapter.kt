package cowma.katotama.twittersearchapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TwitterListAdapter(context:Context, mTwitterList: List<TwitterModel>):
    ArrayAdapter<TwitterModel>(context, 0, mTwitterList) {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val mTwitterList = mTwitterList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Modelの取得
        val model = mTwitterList[position]

        // レイアウトの設定
        var view = convertView
        if (convertView == null) view = layoutInflater.inflate(R.layout.twitter_layout, parent, false)

        // 各Viewの設定
        val imageView = view?.findViewById<ImageView>(R.id.icon_image)
        imageView?.setImageBitmap(model.iconImage)

        val name = view?.findViewById<TextView>(R.id.username_text)
        name?.text = model.userName

        val age = view?.findViewById<TextView>(R.id.comment_text)
        age?.text = model.comment

        return view!!
    }
}