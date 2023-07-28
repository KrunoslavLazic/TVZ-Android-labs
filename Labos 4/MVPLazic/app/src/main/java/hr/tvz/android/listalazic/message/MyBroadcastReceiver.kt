package hr.tvz.android.listalazic.message

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action == "android.intent.action.BOOT_COMPLETED") {

            Toast.makeText(context, "Application started!", Toast.LENGTH_SHORT).show()
        }
    }
}
