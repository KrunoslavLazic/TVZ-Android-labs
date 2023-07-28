package hr.tvz.android.listalazic

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listalazic.model.GroceryItem

class GroceryItemDetailsActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grocery_item)

        val gitem = intent.getParcelableExtra<GroceryItem>("gitem")
        val itemImageView: ImageView = findViewById(R.id.image_view)
        val animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        val linearLayout: LinearLayout = findViewById(R.id.your_linear_layout_id)
        linearLayout.startAnimation(animation)

        if (gitem != null){

            findViewById<TextView>(R.id.name_text_view).setText(gitem.name)
            findViewById<TextView>(R.id.country_text_view).setText(gitem.country)
            findViewById<TextView>(R.id.calories_text_view).setText(gitem.calories.toString() + "kcal")
            findViewById<TextView>(R.id.price_text_view).setText(gitem.price.toString() + "€")



            val imageResId = when (gitem.name) {
                "Banana" -> R.drawable.bananas
                "Milk" -> R.drawable.milk
                "Broccoli" -> R.drawable.broccoli
                "Cheese" -> R.drawable.cheese
                "Eggs" -> R.drawable.egg
                else -> R.drawable.bananas
            }

            itemImageView.setImageResource(imageResId)
            itemImageView.setOnClickListener{

                val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
                itemImageView.startAnimation(fadeOutAnimation)

                Handler(Looper.getMainLooper()).postDelayed({

                    openUrl(getUrlForGroceryItem(gitem.name))

                }, 500)
            }

        }
    }
    private fun getUrlForGroceryItem(itemName: String): String{
        return when (itemName){
            "Banana" -> getString(R.string.bananaURL)
            "Milk" -> getString(R.string.mlijekoURL)
            "Broccoli" -> getString(R.string.brokulaURL)
            "Cheese" -> getString(R.string.sirURL)
            "Eggs" -> getString(R.string.jajaURL)
            else -> ""
        }
    }
    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

}