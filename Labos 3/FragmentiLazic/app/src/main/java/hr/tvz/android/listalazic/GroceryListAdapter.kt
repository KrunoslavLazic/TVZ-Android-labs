package hr.tvz.android.listalazic

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GroceryListAdapter(private var groceryList: List<GroceryItem>) :
    RecyclerView.Adapter<GroceryListAdapter.ViewHolder>(){

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val groceryName: TextView = itemView.findViewById(R.id.grocery_name)

            init {
                itemView.setOnClickListener{
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val clickedItem = groceryList[position]
                        val intent= Intent(itemView.context,GroceryItemDetailsActivity::class.java)
                        intent.putExtra("gitem",clickedItem)
                        itemView.context.startActivity(intent)
                        Toast.makeText(itemView.context,"Click works! " + clickedItem.name,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grocery_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val groceryItem = groceryList[position]
        holder.groceryName.text = groceryItem.name
    }

    override fun getItemCount(): Int = groceryList.size

    fun updateGroceryItemList(convertedGroceryList: List<GroceryItem>) {
        groceryList = convertedGroceryList
        notifyDataSetChanged()
    }
}