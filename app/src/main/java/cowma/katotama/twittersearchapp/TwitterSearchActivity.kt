package cowma.katotama.twittersearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.twitter_search_activity.*

class TwitterSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.twitter_search_activity)

        search_button.setOnClickListener {
            Toast.makeText(this,"Keyword:${insert_keyword_Text.text}",Toast.LENGTH_SHORT).show()
            //TODO twitter api client execute
        }

    }
}
