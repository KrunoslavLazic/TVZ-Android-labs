package hr.tvz.android.listalazic

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities=[GroceryItemEntity::class], version = 1)

abstract class GroceryItemsDB : RoomDatabase() {
    abstract fun groceryItemDao() : GroceryItemDao

}