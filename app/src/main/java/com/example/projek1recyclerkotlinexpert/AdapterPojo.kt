package com.example.projek1recyclerkotlinexpert

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPojo (val context: Context, val itemPojo: List<ItemPojo>, private val listener: (ItemPojo) -> Unit):
        RecyclerView.Adapter<AdapterPojo.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent, false))
    }

    override fun getItemCount(): Int {
             return  itemPojo.size
         }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initData(itemPojo[position],listener)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ima = view.findViewById<TextView>(R.id.tv_item_name)
        val foto = view.findViewById<CircleImageView>(R.id.img_item_photo)
        fun initData(itemPojo: ItemPojo, listener: (ItemPojo) -> Unit){

            ima.text =  itemPojo.name
            itemPojo.image.let { Picasso.get().load(it).into(foto) }

            itemView.setOnClickListener {
                listener(itemPojo)
            }


        }
    }
}