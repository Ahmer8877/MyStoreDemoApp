package com.e.ahmer.bottomnavigation

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productlist: List<ProductX>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemview= LayoutInflater.from(context).inflate(R.layout.apnastyle,parent,false)
        return MyViewHolder(itemview)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productlist[position]
        holder.title.text = currentItem.title
        holder.price.text=currentItem.price.toString()
        Picasso.get().load(currentItem.thumbnail).into(holder.imageview)
    }

    override fun getItemCount(): Int {
       return productlist.size
    }

    class MyViewHolder(itenview : View): RecyclerView.ViewHolder(itenview) {

        val imageview : ShapeableImageView
        val title : TextView
        val price : TextView
        init {
            title = itemView.findViewById(R.id.productTitle)
            price=itenview.findViewById(R.id.productprice)

            imageview=itenview.findViewById(R.id.productImage)
        }
    }
}