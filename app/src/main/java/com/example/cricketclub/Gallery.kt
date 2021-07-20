package com.example.cricketclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class Gallery : AppCompatActivity() {
    private lateinit var newRecyclerView: ViewPager2
    private lateinit var newArrayList: ArrayList<GalleryData>
    lateinit var images : Array<Int>
    lateinit var player:String
    lateinit var pname:TextView
    lateinit var cname:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
       player =intent.getStringExtra("player").toString()
        when(player){
            "Virat Kohli" -> {
                cname=findViewById(R.id.gpCountry)
                cname.text="India"
                images= arrayOf(
                    R.drawable.kohli1,
                    R.drawable.kohli2,
                    R.drawable.kohli3

                )
            }

        }


        newRecyclerView=findViewById(R.id.viewPager)
        pname=findViewById(R.id.gpName)
        pname.text=player
        newArrayList= arrayListOf<GalleryData>()
        getData()
    }
    private fun getData() {
        for (i in images.indices)
        {
            val iData=GalleryData(images[i])
            newArrayList.add(iData)
        }
        newRecyclerView.adapter=GalleryAdapter(this,newArrayList)
    }
}