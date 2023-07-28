package hr.tvz.android.listalazic

import android.os.Parcel
import android.os.Parcelable

class GroceryItem(
    val name: String,
    val country: String,
    val calories: Int,
    val price: Double
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(country)
        parcel.writeInt(calories)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GroceryItem> {
        override fun createFromParcel(parcel: Parcel): GroceryItem {
            return GroceryItem(parcel)
        }

        override fun newArray(size: Int): Array<GroceryItem?> {
            return arrayOfNulls(size)
        }
    }

}