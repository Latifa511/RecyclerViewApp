package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

     lateinit var clayout: ConstraintLayout
     lateinit var gField: EditText
     lateinit var gButton: Button
     lateinit var messages: ArrayList<String>
     lateinit var rvMessages : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clayout = findViewById(R.id.clayout)
        messages = ArrayList()
        rvMessages = findViewById(R.id.rvMessages)

        rvMessages.adapter = RecyclerViewAdapter(this, messages)
        rvMessages.layoutManager = LinearLayoutManager(this)

        gField = findViewById(R.id.etField)
        gButton = findViewById(R.id.btButton)

        gButton.setOnClickListener { addMessage() }
    }

     fun addMessage(){
        val msg = gField.text.toString()
        if(msg.isNotEmpty()){
            messages.add(msg)
            gField.text.clear()
            gField.clearFocus()
        }else{
            Snackbar.make(clayout, "Please enter some text", Snackbar.LENGTH_LONG).show()
        }
    }
}







