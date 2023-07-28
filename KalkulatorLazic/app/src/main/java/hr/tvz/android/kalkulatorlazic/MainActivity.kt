package hr.tvz.android.kalkulatorlazic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var bullseyeButton: ImageButton
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bullseyeButton = findViewById(R.id.bullseye)
        editText = findViewById(R.id.editText)

        bullseyeButton.setOnClickListener{
            val inputText = editText.text.toString().toDoubleOrNull()

            when{
                inputText == null -> showToast("Please insert an amount!")
                inputText < 0.1   -> showToast("You're not a bug, insert more!")
                inputText > 20    -> showToast("You're not a whale yet, insert less!")
                else -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    intent.putExtra("goalValue",inputText.toFloat())
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in_xml,0)
                }
            }
        }
    }
    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}