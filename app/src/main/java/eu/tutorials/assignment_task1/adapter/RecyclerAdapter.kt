package eu.tutorials.assignment_task1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eu.tutorials.assignment_task1.OnItemClickListener
import eu.tutorials.assignment_task1.R
import eu.tutorials.assignment_task1.model.Shopping

class RecyclerAdapter(val context: Context, val clickListner: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var itemList: ArrayList<Shopping> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.gridlist_cardlayout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(itemList[position].image).into(holder.image)
        holder.icon.setImageResource(R.drawable.hearticon)
        holder.name.text = itemList[position].name
        holder.description.text = itemList[position].description
        holder.L1.setOnClickListener {
            clickListner.onclick(itemList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val icon: ImageView = itemView.findViewById(R.id.wishlist)
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.desc)
        val L1: LinearLayout = itemView.findViewById(R.id.Linear)
    }

    fun setList(list: ArrayList<Shopping>) {
        itemList = list
        notifyDataSetChanged()
    }

}