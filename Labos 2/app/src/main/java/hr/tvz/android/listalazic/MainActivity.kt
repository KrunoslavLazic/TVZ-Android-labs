package hr.tvz.android.listalazic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var groceryList: List<GroceryItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_grocery_list)
        var adapter: RecyclerView.Adapter<*>
        var layoutManager: RecyclerView.LayoutManager


        recyclerView.setHasFixedSize(true)
        layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

        groceryList = listOf(
            GroceryItem("Banana","Bosnia", 70, 1.5),
            GroceryItem("Milk","Croatia", 40, 1.0),
            GroceryItem("Broccoli","Hungary", 26, 0.7),
            GroceryItem("Cheese","France", 150, 2.0),
            GroceryItem("Eggs","Slovenia", 70,3.0)
        )

        adapter=GroceryListAdapter(groceryList)
        recyclerView.adapter=adapter

    }

}