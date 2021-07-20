package com.example.cricketclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<CountryData>
    lateinit var flags : Array<Int>
    lateinit var cname:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flags= arrayOf(
            R.drawable.australia,
            R.drawable.bangladesh,
            R.drawable.england,
            R.drawable.india,
            R.drawable.newswland,
            R.drawable.pakistan,
            R.drawable.southafrica,
            R.drawable.sreelanka,
            R.drawable.westindies,
            R.drawable.zimbabwe

        )
        cname= arrayOf(
            "Australia",
            "Bangladesh",
            "England",
            "India",
            "New Zealand",
            "Pakistan",
            "South Africa",
            "SreeLanka",
            "West Indies",
            "Zimbabwe"
        )

        newRecyclerView = findViewById(R.id.rcView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        newArrayList= arrayListOf<CountryData>()
        getData()
    }

    private fun getData() {
        for (i in flags.indices)
        {
            val cData = CountryData(flags[i],cname[i])
            newArrayList.add(cData)
        }
        newRecyclerView.adapter=CountryAdapter(this,newArrayList)
    }
}