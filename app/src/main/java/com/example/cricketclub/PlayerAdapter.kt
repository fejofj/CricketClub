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

class PlayerAdapter(private val context: Context,private val playerList:ArrayList<PlayerData>):
RecyclerView.Adapter<PlayerAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val pimage = view.findViewById<ImageView>(R.id.playerImage)
        val pname = view.findViewById<TextView>(R.id.playerName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = playerList[position]
        holder.pimage.setImageResource(current.image)
        holder.pname.text=current.pName
        holder.itemView.setOnClickListener{
           val intent = Intent(context,Gallery::class.java).apply {
               putExtra("player",current.pName)
           }
            ContextCompat.startActivity(context,intent,null)
        }
    }

    override fun getItemCount(): Int {
       return playerList.size
    }
}