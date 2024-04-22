package com.example.khata_book_application.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khata_book_application.Controller.New_Contect_Adpter
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.databinding.ActivityMoneyShowBinding

lateinit var blinding: ActivityMoneyShowBinding

class Money_Show_Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blinding = ActivityMoneyShowBinding.inflate(layoutInflater)
        setContentView(blinding.root)

        blinding.relativeViewMoney.setOnClickListener {



        }

    }


}
