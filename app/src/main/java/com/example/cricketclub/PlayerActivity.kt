package com.example.cricketclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayerActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<PlayerData>
    lateinit var playerImage:Array<Int>
    lateinit var playerName:Array<String>
    lateinit var country:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        country = intent.getStringExtra("country").toString()
        when(country){
            "Australia" -> {
                playerImage= arrayOf(
                R.drawable.adamzampa,
                R.drawable.davidwarner,
                R.drawable.jasonkrejza,
                R.drawable.peterhandscomb
            )
            playerName= arrayOf("Adam Zampa",
            "David Warner",
            "Jason Krejza",
            "Peter Handscomb")
            }

            "India" -> {
                playerImage= arrayOf(
                    R.drawable.viratkohli,
                    R.drawable.klrahul,
                    R.drawable.rishandpant,
                    R.drawable.rohitsharma
                )
                playerName= arrayOf(
                    "Virat Kohli",
                    "KL Rahul",
                    "Rishand Pant",
                    "Rohit Sharma"

                )
            }
        }

        newRecyclerView=findViewById(R.id.playerRcView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)

        newArrayList= arrayListOf<PlayerData>()
        getData()
    }

    private fun getData() {
        for (i in playerImage.indices){
            val pData = PlayerData(playerImage[i],playerName[i])
            newArrayList.add(pData)
        }
        newRecyclerView.adapter=PlayerAdapter(this,newArrayList)
    }
}