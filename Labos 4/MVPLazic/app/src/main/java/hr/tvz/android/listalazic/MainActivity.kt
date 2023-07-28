package hr.tvz.android.listalazic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,listFragment)
            .commit()

        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.background)
        mediaPlayer.start()

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("Main activity", "getInstanceId failed", task.exception)
                    return@addOnCompleteListener
                }

                val token = task.result

                Log.d("Main activity token:", token)
                Toast.makeText(this@MainActivity, token, Toast.LENGTH_SHORT).show()
            }
    }


}
