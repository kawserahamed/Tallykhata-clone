package com.example.khata_book_application.Controller

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.R
import com.example.khata_book_application.View.Add_Custmer_Data
import com.example.khata_book_application.View.MainActivity
import com.example.khata_book_application.View.Money_Show_Activity

class New_Contect_Adpter(

    val newContectActivity: MainActivity,
    val l1: List<ModelData>
) :
    RecyclerView.Adapter<New_Contect_Adpter.ViewData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {

        var view = LayoutInflater.from(newContectActivity).inflate(R.layout.item, parent, false)

        return New_Contect_Adpter.ViewData(view)
    }

    override fun onBindViewHolder(holder: New_Contect_Adpter.ViewData,position: Int)
    {

       // holder.txt_id.text = l1[position].id
        holder.txt_name.text = l1[position].name
        holder.txt_moblie.text = l1[position].mobile

        if (l1[position].type.equals("0")) {
            holder.txtRuppesExport.text = l1[position].ruppes
        } else {
            holder.incomeTxtItem.text = l1[position].ruppes
        }


        holder.time_txt.text =  l1[position].time
        holder.date_txt.text =  l1[position].date
        holder.rv_view.setOnClickListener {

            val intent = Intent(newContectActivity, Add_Custmer_Data::class.java)
            intent.putExtra("ps",position)
            intent.putExtra("name", l1[position].name)
            intent.putExtra("mobile", l1[position].mobile)
            intent.putExtra("id", l1[position].id)
            intent.putExtra("ruppes", l1[position].ruppes)
            intent.putExtra("type", l1[position].type)
            intent.putExtra("time", l1[position].time)
            intent.putExtra("date", l1[position].date)
            newContectActivity.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return l1.size
    }


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

       // var txt_id = itemView.findViewById<TextView>(R.id.txt_id)
        var txt_name = itemView.findViewById<TextView>(R.id.txt_name)
        var txt_moblie = itemView.findViewById<TextView>(R.id.txt_moblie)
        var txtRuppesExport = itemView.findViewById<TextView>(R.id.txtRuppesExport)
        var rv_view = itemView.findViewById<RelativeLayout>(R.id.rv_view)
        var incomeTxtItem = itemView.findViewById<TextView>(R.id.incomeTxtItem)
        var time_txt = itemView.findViewById<TextView>(R.id.time_txt)
        var date_txt = itemView.findViewById<TextView>(R.id.date_txt)
    }

}