package com.example.cricketclub

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private var context: Context, private val countrylist:ArrayList<CountryData>):
        RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

            class ViewHolder(view: View):RecyclerView.ViewHolder(view){
                val flag = view.findViewById<ImageView>(R.id.countryFlag)
                val cname=view.findViewById<TextView>(R.id.countryName)

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.countries_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = countrylist[position]
        holder.flag.setImageResource(current.countryFlag)
        holder.cname.text=current.countryName

        holder.itemView.setOnClickListener{
            //Toast.makeText(context, current.countryName, 100).show()
            val intent = Intent(context,PlayerActivity::class.java).apply {
                putExtra("country",current.countryName)
            }
            ContextCompat.startActivity(context,intent,null)

        }
    }

    override fun getItemCount(): Int {
    return countrylist.size
    }

}