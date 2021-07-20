package com.example.cricketclub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class GalleryAdapter(private val context: Context,private val imageList:ArrayList<GalleryData>):
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val galImage = view.findViewById<ImageView>(R.id.imageView)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.image_slider,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryAdapter.ViewHolder, position: Int) {
        val current = imageList[position]
        holder.galImage.setImageResource(current.images)

    }

    override fun getItemCount(): Int {
       return imageList.size
    }
}