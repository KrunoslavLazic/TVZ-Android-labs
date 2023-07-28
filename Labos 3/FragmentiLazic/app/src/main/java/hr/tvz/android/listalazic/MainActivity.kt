package hr.tvz.android.listalazic

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.firebase.messaging.FirebaseMessaging
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var groceryList: List<GroceryItem>
    private lateinit var groceryItemsDB: GroceryItemsDB
    private var adapter: GroceryListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_grocery_list)
        val layoutManager: RecyclerView.LayoutManager

        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    /*
        groceryItemsDB = Room.databaseBuilder(
            applicationContext,
            GroceryItemsDB::class.java,"database-name"
        )
            .allowMainThreadQueries()
            .build()

        val groceryItemDao = groceryItemsDB.groceryItemDao()
        val forInsertList = InsertGroceryItems()
        groceryItemDao.insertGroceryItems(forInsertList)
        */

        groceryList = listOf(
            GroceryItem("Banana","Bosnia", 70, 1.5),
            GroceryItem("Milk","Croatia", 40, 1.0),
            GroceryItem("Broccoli","Hungary", 26, 0.7),
            GroceryItem("Cheese","France", 150, 2.0),
            GroceryItem("Eggs","Slovenia", 70,3.0)
        )

        adapter=GroceryListAdapter(groceryList)
        recyclerView.adapter=adapter



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

    private fun InsertGroceryItems(): List<GroceryItemEntity> {
        val initializeGroceryItemsArray = ArrayList<GroceryItemEntity>()
        initializeGroceryItemsArray.add(
            GroceryItemEntity(1,"Banana","Bosnia", 70, 1.5))
        initializeGroceryItemsArray.add(
            GroceryItemEntity(2,"Milk","Croatia", 40, 1.0))
        initializeGroceryItemsArray.add(
            GroceryItemEntity(3,"Broccoli","Hungary", 26, 0.7))
        initializeGroceryItemsArray.add(
            GroceryItemEntity(4,"Cheese","France", 150, 2.0))
        initializeGroceryItemsArray.add(
            GroceryItemEntity(5,"Eggs","Slovenia", 70,3.0))

        return initializeGroceryItemsArray
    }
    private fun convertToGroceryItemList(groceryItemEntities: List<GroceryItemEntity>): List<GroceryItem> {
        val groceryItemList: MutableList<GroceryItem> = ArrayList()
        for (gitemEntity in groceryItemEntities) {
            val gitem = GroceryItem(
                gitemEntity.name,
                gitemEntity.country,
                gitemEntity.calories,
                gitemEntity.price
            )
            groceryItemList.add(gitem)
        }
        return groceryItemList
    }
}
