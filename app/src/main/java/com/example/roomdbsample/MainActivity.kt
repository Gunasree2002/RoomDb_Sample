package com.example.roomdbsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import kotlinx.coroutines.*
import org.w3c.dom.Text
import javax.microedition.khronos.egl.EGLDisplay

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var enter: EditText
    lateinit var adding: Button
    lateinit var contentList: List<ContentText>
    lateinit var database: RoomDb
    lateinit var adapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this, RoomDb::class.java, "content_Details").build()
        recyclerView = findViewById(R.id.added_text)
        enter = findViewById(R.id.enter_text)
        adding = findViewById(R.id.button)


        val viewModelJob: Job = Job()
        val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


        adding.setOnClickListener(View.OnClickListener {
                println("button clicked")
            val userText: String = enter.text.toString()
            coroutineScope.launch {
                withContext(Dispatchers.IO) {
                    println(userText)
                    val t = ContentText(0, userText)
                    database.RoomDao().insert(t)

                }
            }
            enter.setText("")
        })

        database.RoomDao().getContent().observe(this,
            object : Observer<List<ContentText>> {
                override fun onChanged(t: List<ContentText>?) {
                    t?.let {
                        contentList = it
                        setAdapter()

                    }
                }
            })

    }

    private fun setAdapter() {
         adapter = RecyclerAdapter(this,contentList)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.setLayoutManager(linearLayoutManager)
        recyclerView.setAdapter(adapter)
    }

}