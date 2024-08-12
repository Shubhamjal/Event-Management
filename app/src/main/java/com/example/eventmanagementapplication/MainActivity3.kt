package com.example.eventmanagementapplication

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eventmanagementapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(),RecyclerAdapter.onclick {
    lateinit var binding: ActivityMain3Binding
    var sportList= arrayListOf<SportsEntity>()
    lateinit var sportsDataBase: SportsDataBase
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sportsDataBase=SportsDataBase.getInstance(this)

        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.fabaddsportevent.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.add_sport_activity_dialogbox)
            val enter_name = dialog.findViewById<EditText>(R.id.EnteEventName)
            val enter_date = dialog.findViewById<EditText>(R.id.EnterEventDate)
            val add_btn = dialog.findViewById<Button>(R.id.addSportsEventbtn)
            dialog.show()

            add_btn.setOnClickListener {
                val name_entered = enter_name.text.toString()
                val date_entered = enter_date.text.toString()
                sportsDataBase.sportsInterface().insertTodo(SportsEntity(Title = date_entered, Status = name_entered))
                getList()
                recyclerAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }


    }






    override fun update(position: Int) {
        TODO("Not yet implemented")
    }

    override fun delete(position: Int) {
        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show()
        sportsDataBase.sportsInterface().deleteTodoEntity(sportList[position])
        getList()
        recyclerAdapter.notifyDataSetChanged()
    }


    private fun getList() {
        sportList.clear()
        sportList.addAll(sportsDataBase.sportsInterface().getList())

    }



}