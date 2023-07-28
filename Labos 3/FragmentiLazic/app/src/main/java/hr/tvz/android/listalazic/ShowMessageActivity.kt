package hr.tvz.android.listalazic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.messaging.RemoteMessage

class ShowMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_message)

        val remoteMessage: RemoteMessage? = intent.extras!!.getParcelable("poruka")
        (findViewById<View>(R.id.tvOd) as TextView).text = remoteMessage!!.from
        (findViewById<View>(R.id.tvPoruka) as TextView).text = remoteMessage!!.notification!!.body
    }
}