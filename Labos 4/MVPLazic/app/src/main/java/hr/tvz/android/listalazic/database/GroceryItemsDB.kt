package hr.tvz.android.listalazic.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[GroceryItemEntity::class], version = 1)

abstract class GroceryItemsDB : RoomDatabase() {
    abstract fun groceryItemDao() : GroceryItemDao

}