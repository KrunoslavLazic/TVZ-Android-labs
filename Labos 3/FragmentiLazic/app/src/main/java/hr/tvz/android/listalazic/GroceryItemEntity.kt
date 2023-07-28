package hr.tvz.android.listalazic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class GroceryItemEntity(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @ColumnInfo var name: String,
        @ColumnInfo var country : String,
        @ColumnInfo var calories : Int,
        @ColumnInfo var price : Double
)