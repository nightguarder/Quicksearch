package com.example.quicksearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksearch.adapter.LanguageAdapter
import com.example.quicksearch.model.LanguageData
import java.util.Locale

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
        addLanguageData()
        //initialize default View
        adapterInitialize(mList)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //No action needed
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //search for the input text
                filterList(newText)
                return true
            }
        })


    }
    fun filterList(query: String?) {
        //Show All language skills by default
        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun adapterInitialize(list: ArrayList<LanguageData>){
        adapter = LanguageAdapter(list)
        recyclerView.adapter = adapter
    }
    private fun addLanguageData(){

        mList.add(LanguageData("SvelteKit", R.drawable.svelte))
        mList.add(LanguageData("React", R.drawable.react))
        mList.add(LanguageData("NextJs", R.drawable.nextjs))
        mList.add(LanguageData("Docker", R.drawable.docker))
        mList.add(LanguageData("Kotlin", R.drawable.kotlin))
        mList.add(LanguageData("C, C++", R.drawable.cplusplus))
        mList.add(LanguageData("HTML", R.drawable.html))
        mList.add(LanguageData("CSS", R.drawable.css))
        mList.add(LanguageData("JavaScript", R.drawable.javascript))
    }

}