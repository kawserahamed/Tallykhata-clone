package com.example.khata_book_application.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.khata_book_application.R


class Rupees_Fragment : Fragment() {

    lateinit var j2: String
    lateinit var name_binss1: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_rupees_, container, false)

          name_binss1 = view.findViewById<TextView>(R.id.name_binss1)


//        name_binss1.text = j2

        getShr()
        return view

    }




    fun getShr(): String? {
        var shr = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        var data = shr.getString("name", null)
        name_binss1.text= data
        return data

    }


}