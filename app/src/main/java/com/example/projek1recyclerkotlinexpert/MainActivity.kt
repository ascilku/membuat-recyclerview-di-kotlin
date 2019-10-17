package com.example.projek1recyclerkotlinexpert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv_container : RecyclerView
    private val itemPojo : MutableList<ItemPojo> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_container = findViewById(R.id.rv_container)
        iniData()
        rv_container.layoutManager = LinearLayoutManager(this)
        rv_container.adapter = AdapterPojo(this, itemPojo){
            val to = Toast.makeText(applicationContext,it.name, Toast.LENGTH_SHORT)
            to.show()
        }

    }

    fun iniData(){
        val name = resources.getStringArray(R.array.string_name)
        val  image = resources.obtainTypedArray(R.array.string_image)
        itemPojo.clear()
            for (i in name.indices){
                itemPojo.add(ItemPojo(name[i], image.getResourceId(i,0)))
            }
        image.recycle()
    }


}
