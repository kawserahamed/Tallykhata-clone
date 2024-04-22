package com.example.khata_book_application.View

import android.app.Dialog
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.khata_book_application.DB_Helper
import com.example.khata_book_application.R

class Add_Custmer_Data : AppCompatActivity() {

        lateinit var id: String
        lateinit var t1: String

        lateinit var type: String
        lateinit var mobile: String
        lateinit var time: String
        lateinit var date: String
        lateinit var edit_name_data: EditText
        lateinit var edit_mobile_data: EditText
        lateinit var update_item_btn: Button
        lateinit var name_add_customer: TextView
        lateinit var details_name_txt: TextView
        lateinit var details_num_txt: TextView
        lateinit var date_income_details: TextView
        lateinit var amount_details_txt: TextView
        lateinit var editEntery: TextView
        lateinit var date_txt: TextView
        lateinit var time_txt: TextView
        lateinit var ArrowNewContectActivity: ImageView
        lateinit var ex_details: ImageView
        lateinit var out_details: ImageView
        lateinit var callAddCustomer: ImageView
        lateinit var call_img: ImageView
        lateinit var name: String
        lateinit var ruppes: String
        lateinit var delete_Data_expence: RelativeLayout

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_custmer_data)

        blinding()
        val position=intent.getStringExtra("ps")
          name = intent.getStringExtra("name").toString()
          mobile = intent.getStringExtra("mobile").toString()
          id = intent.getStringExtra("id").toString()
          ruppes = intent.getStringExtra("ruppes").toString()
          type = intent.getStringExtra("type").toString()
          time = intent.getStringExtra("time").toString()
          date = intent.getStringExtra("date").toString()


        if (type.equals("0")) {
//            var t1 = type
            t1="income"
            date_income_details.setTextColor(getColor(R.color.green))
            amount_details_txt.setTextColor(getColor(R.color.green))
            ex_details.setColorFilter(getColor(R.color.green))
            out_details.setColorFilter(getColor(R.color.green))
            Toast.makeText(this, "$t1", Toast.LENGTH_LONG).show()

        } else {
//            var t1 = type
            t1="expece"
            date_income_details.setTextColor(getColor(R.color.red))
            amount_details_txt.setTextColor(getColor(R.color.red))
            ex_details.setColorFilter(getColor(R.color.red))
            out_details.setColorFilter(getColor(R.color.red))
            Toast.makeText(this, "$t1", Toast.LENGTH_LONG).show()

        }

        details_num_txt.text = mobile
        amount_details_txt.text = ruppes
        date_income_details.text = t1
        time_txt.text=time
        date_txt.text=date

        details_name_txt.text = name
        if (intent.hasExtra("name")) {

            name_add_customer.text = name


        }

        ArrowNewContectActivity.setOnClickListener {

            finish()

        }
            delete_Data_expence.setOnClickListener {
            Toast.makeText(this, "Delet Succesfully .... ", Toast.LENGTH_LONG).show()

            var db = DB_Helper(this)
            db.DelateData(id)
            finish()

        }
        editEntery.setOnClickListener {

            update1(position)

        }
        callAddCustomer.setOnClickListener {


            var dialIntent = Intent(Intent(ACTION_DIAL))
            dialIntent.setData(Uri.parse("tel:$mobile"))
            startActivity(dialIntent)

        }
        call_img.setOnClickListener {

            var dialIntent = Intent(Intent(ACTION_DIAL))
            dialIntent.setData(Uri.parse("tel:$mobile"))
            startActivity(dialIntent)

        }

    }


    fun update1(position: String?) {

        var dialog = Dialog(this)
        dialog.setContentView(R.layout.item_dialod_income)
        dialog.show()

        var customer_name_edt_i = dialog.findViewById<EditText>(R.id.customer_name_edt_i)
        var customer_no_edt_i = dialog.findViewById<EditText>(R.id.customer_no_edt_i)
        var amount_edt_i = dialog.findViewById<EditText>(R.id.amount_edt_i)
        var updateBtnItem = dialog.findViewById<TextView>(R.id.updateBtnItem)

        val name = Editable.Factory.getInstance().newEditable(name)
        val mobile = Editable.Factory.getInstance().newEditable(mobile)
        val ruppes = Editable.Factory.getInstance().newEditable(ruppes)

        customer_name_edt_i.text = name
        customer_no_edt_i.text = mobile
        amount_edt_i.text = ruppes

        updateBtnItem.setOnClickListener {

            DB_Helper(this).UpdateData(id, customer_name_edt_i.text.toString(),customer_no_edt_i.text.toString(),amount_edt_i.text.toString())

            details_name_txt.text = customer_name_edt_i.text.toString()
            name_add_customer.text = customer_name_edt_i.text.toString()
            details_num_txt.text =customer_no_edt_i.text.toString()
            amount_details_txt.text = amount_edt_i.text.toString()

            dialog.dismiss()

        }

    }


    fun blinding() {

        name_add_customer = findViewById<TextView>(R.id.name_add_customer)
        ArrowNewContectActivity = findViewById<ImageView>(R.id.ArrowNewContectActivity)
        out_details = findViewById<ImageView>(R.id.out_details)
        ex_details = findViewById<ImageView>(R.id.ex_details)
        delete_Data_expence = findViewById<RelativeLayout>(R.id.delete_Data_expence)
        editEntery = findViewById<TextView>(R.id.editEntery)
        details_name_txt = findViewById<TextView>(R.id.details_name_txt)
        details_num_txt = findViewById<TextView>(R.id.details_num_txt)
        amount_details_txt = findViewById<TextView>(R.id.amount_details_txt)
        date_income_details = findViewById<TextView>(R.id.date_income_details)
        callAddCustomer = findViewById<ImageView>(R.id.callAddCustomer)
        call_img = findViewById<ImageView>(R.id.call_img)
        time_txt = findViewById<TextView>(R.id.time_txt)
        date_txt = findViewById<TextView>(R.id.date_txt)

    }

}