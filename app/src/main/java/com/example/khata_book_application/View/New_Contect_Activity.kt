package com.example.khata_book_application.View

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.DB_Helper
import com.example.khata_book_application.Fragment.Home_Fragment
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.R
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class New_Contect_Activity : AppCompatActivity() {


    lateinit var rv_3_AddNewCustomer: RelativeLayout
    lateinit var rv4: RelativeLayout
    lateinit var edit_name_data: TextInputEditText
    lateinit var edit_mobile_data: TextInputEditText
    lateinit var edit_ruppes: TextInputEditText
    lateinit var Continue_item_btn: Button
    lateinit var recycleview: RecyclerView
    lateinit var redioGup1: RadioGroup
    lateinit var rdBtn1: RadioButton
    lateinit var rdBtn2: RadioButton
    lateinit var ArrowNewContectActivity: ImageView


    var list = arrayListOf<ModelData>()
    lateinit var stats: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_contect_activity)

        blinding()

        ArrowNewContectActivity.setOnClickListener {
            finish()
        }

        rv_3_AddNewCustomer.setOnClickListener {

//            Toast.makeText(this, "  ADD  ", Toast.LENGTH_SHORT).show()

            rv4.isVisible = true

        }


        var db = DB_Helper(this)
//        list = db.readData()
//        setUpRv(list)

        Continue_item_btn.setOnClickListener {

            if (redioGup1.getCheckedRadioButtonId() == R.id.rdBtn1) {
                stats = "0"

            } else {
                stats = "1"
            }
            var c = Calendar.getInstance()
            var simple = SimpleDateFormat("dd/MM/yyyy")
            var datecurrent = simple.format(c.time).toString()

            var calendar = Calendar.getInstance()
            var simpleDateFormat = SimpleDateFormat("KK:mm aaa ")
            var dateTime = simpleDateFormat.format(calendar.time).toString()


            db.insertData(

                edit_name_data.text.toString(),
                edit_mobile_data.text.toString(),
                edit_ruppes.text.toString(),
                stats,dateTime,datecurrent

            )

//            var intent = Intent(this, Add_Custmer_Data::class.java)
//            intent.putExtra("name", edit_name_data.text.toString())
//            intent.putExtra("mobile", edit_mobile_data.text.toString())
//            startActivity(intent)


//            val intent = Intent(this, Home_Fragment::class.java)
//            intent.putExtra("name", edit_name_data.text.toString())
//            intent.putExtra("mobile", edit_mobile_data.text.toString())
//            startActivity(intent)

            finish()
            rv4.isVisible = false


//            list = db.readData()
//            setUpRv(list)


        }
    }


    fun blinding() {

        rv_3_AddNewCustomer = findViewById<RelativeLayout>(R.id.rv_3_AddNewCustomer)
        rv4 = findViewById<RelativeLayout>(R.id.rv4)
        edit_name_data = findViewById<TextInputEditText>(R.id.edit_name)
        edit_mobile_data = findViewById<TextInputEditText>(R.id.edit_mobile)
        edit_ruppes = findViewById<TextInputEditText>(R.id.edit_ruppes)
        Continue_item_btn = findViewById<Button>(R.id.Continue_item_btn)
        recycleview = findViewById<RecyclerView>(R.id.recycleview)
        redioGup1 = findViewById<RadioGroup>(R.id.redioGup1)
        rdBtn1 = findViewById<RadioButton>(R.id.rdBtn1)
        rdBtn2 = findViewById<RadioButton>(R.id.rdBtn2)
        ArrowNewContectActivity = findViewById<ImageView>(R.id.ArrowNewContectActivity)

    }


//    fun setUpRv(l1: ArrayList<ModelData>) {
//        var adpter = New_Contect_Adpter(this, l1)
//        var lm = LinearLayoutManager(this)
//        recycleview.layoutManager = lm
//        recycleview.adapter = adpter
//        val helper: SnapHelper = LinearSnapHelper()
//        helper.attachToRecyclerView(recycleview)
//    }

}