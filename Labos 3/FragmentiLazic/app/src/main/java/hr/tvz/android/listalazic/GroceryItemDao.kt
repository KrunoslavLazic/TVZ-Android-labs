package hr.tvz.android.listalazic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroceryItemDao {

    @Query("SELECT * FROM GroceryItemEntity")
    fun getAllGroceryItems(): List<GroceryItemEntity>

    @Insert
    fun insertGroceryItems(groceryItems: List<GroceryItemEntity>)
}