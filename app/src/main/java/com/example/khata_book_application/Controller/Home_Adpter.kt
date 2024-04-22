package com.example.khata_book_application.Controller

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.R

class Home_Adpter(val activity: FragmentActivity?,val l1: ArrayList<ModelData>) :

    RecyclerView.Adapter<Home_Adpter.ViewData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {


        var view = LayoutInflater.from(activity).inflate(R.layout.item, parent, false)

        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {


    }


    override fun getItemCount(): Int {


          return l1.size

    }


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {


        }


    fun Update_Dialog() {

//        var dialog=Dialog(activity)
//        dialog.setContentView(R.layout.dilog_item)
//         dialog.show()

    }


}

