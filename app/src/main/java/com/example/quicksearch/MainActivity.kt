package com.example.quicksearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksearch.adapter.LanguageAdapter
import com.example.quicksearch.model.LanguageData

class MainActivity : AppCompatActivity() {

    //Private variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView //SearchView is androidx.appcompat!!!
    private var mList = ArrayList<LanguageData>()//Created in com.example.model

    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        //Setup the View screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize variables
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.quickSearch)

        //handle the display of the recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Add data to list
        addLanguageData();
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter


    }
    private fun addLanguageData(){
        mList.add(LanguageData("Kotlin", R.drawable.kotlin))
        mList.add(LanguageData("C++", R.drawable.cplusplus))
        mList.add(LanguageData("HTML", R.drawable.html))
        mList.add(LanguageData("JavaScript", R.drawable.javascript))
    }

}