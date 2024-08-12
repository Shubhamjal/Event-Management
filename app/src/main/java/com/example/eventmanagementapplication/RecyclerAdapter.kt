package com.example.eventmanagementapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var list:ArrayList<SportsEntity>,var clickInterface:onclick ):
RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        var Event_Name=view.findViewById<TextView>(R.id.ActivityName)
        var DateofEvent=view.findViewById<TextView>(R.id.ActivityDate)
        var EventStatus=view.findViewById<TextView>(R.id.ActivityStatus)
        var Updatebtn=view.findViewById<Button>(R.id.Update_btn)
        var Deletebtn=view.findViewById<Button>(R.id.Delete_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.base_sport_event_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.apply{
            Event_Name.setText(list[position].Title)
            EventStatus.setText(list[position].Status)


            Updatebtn.setOnClickListener {
                clickInterface.update(position)
            }
            Deletebtn.setOnClickListener {
                clickInterface.delete(position)
            }


        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onclick {
        fun update(position: Int)
        fun delete(position: Int)

    }


}