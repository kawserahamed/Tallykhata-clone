package com.example.khata_book_application.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.khata_book_application.Fragment.Home_Fragment
import com.example.khata_book_application.Fragment.Rupees_Fragment
import com.example.khata_book_application.R
import com.example.khata_book_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var blinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)

        blinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(blinding.root)

        loadfragment(Home_Fragment(this))


    /*    blinding.HomeLyBtn.setOnClickListener {
            loadfragment(Home_Fragment(this))
        }
        blinding.RupeesLYBtn.setOnClickListener {

            loadfragment(Rupees_Fragment())

        }
        blinding.MoreLYBtn.setOnClickListener {
            loadfragment(Home_Fragment(this))

        }*/


    }

    fun loadfragment(fragment: Fragment) {


        var fragmentTransient = supportFragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.fragment_fgm, fragment)
        fragmentTransient.commit()

    }


}