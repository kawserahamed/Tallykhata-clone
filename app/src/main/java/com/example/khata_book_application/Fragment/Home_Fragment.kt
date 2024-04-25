package com.example.khata_book_application.Fragment

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.Controller.New_Contect_Adpter
import com.example.khata_book_application.DBViewModel
import com.example.khata_book_application.DB_Helper
import com.example.khata_book_application.R
import com.example.khata_book_application.View.MainActivity
import com.example.khata_book_application.View.New_Contect_Activity

class Home_Fragment(val mainActivity: MainActivity) : Fragment() {

    private lateinit var viewmodel: DBViewModel
    lateinit var recycle_view_home: RecyclerView
    lateinit var ADD_CUSTOMER_BTN: RelativeLayout
    lateinit var filterHome: ImageView
    lateinit var total_txt: TextView
    lateinit var txt1Income: TextView
    lateinit var txt3Expence: TextView
    lateinit var name_binss: TextView
    lateinit var cv_add_customer: RelativeLayout
    lateinit var rv_1: RelativeLayout
    lateinit var rg1: RadioGroup
    lateinit var stas1: String
    lateinit var savebtn: Button
    lateinit var j1: String
    private lateinit var adpter: New_Contect_Adpter

    var list = arrayListOf<ModelData>()
    var list1 = arrayListOf<ModelData>()

    var incomeTotal = 0
    var expTotal = 0
    var size: Int = 0


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home_, container, false)
        viewmodel = ViewModelProvider(this).get(DBViewModel::class.java)

        recycle_view_home = view.findViewById<RecyclerView>(R.id.recycle_view_home)
        ADD_CUSTOMER_BTN = view.findViewById<RelativeLayout>(R.id.ADD_CUSTOMER_BTN)
        cv_add_customer = view.findViewById<RelativeLayout>(R.id.cv_add_customer)
        //   rv_1 = view.findViewById<RelativeLayout>(R.id.rv_1)
        filterHome = view.findViewById<ImageView>(R.id.filterHome)
        total_txt = view.findViewById<TextView>(R.id.total_txt)
        txt1Income = view.findViewById<TextView>(R.id.txt1Income)
        txt3Expence = view.findViewById<TextView>(R.id.txt3Expence)
        // name_binss = view.findViewById<TextView>(R.id.name_binss)


        cv_add_customer.setOnClickListener {
            val intent = Intent(activity, New_Contect_Activity::class.java)
            startActivity(intent)

        }


        list1.clear()
        val db = DB_Helper(activity)
        list1 = db.readData()
        viewmodel.setList(list1)
        setUpRv(list1)

        viewmodel.getFilteredList().observe(viewLifecycleOwner) {
            setUpRv(it)
        }

        /*filterHome.setOnClickListener {
            var dialog = Dialog(mainActivity)
            dialog.setContentView(R.layout.filter_item)
            rg1 = dialog.findViewById<RadioGroup>(R.id.rg1)
            savebtn = dialog.findViewById<Button>(R.id.savebtn)
            dialog.show()
            savebtn.setOnClickListener {
                if (rg1.getCheckedRadioButtonId() == R.id.rb1) {
                    stas1 = "0"

                } else {
                    stas1 = "1"

                }
                var db = DB_Helper(activity)
                list1 = db.readData1(stas1)
                Toast.makeText(mainActivity, "$stas1", Toast.LENGTH_LONG).show()
                adpter.notifyDataSetChanged()
                dialog.dismiss()

            }

        }*/


        val editText = view.findViewById<TextView>(R.id.et_search)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this implementation
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed for this implementation
            }

            override fun afterTextChanged(s: Editable?) {
                viewmodel.filter(s.toString())
            }
        })

        return view

    }

    private fun createShr(j1: String) {
        var shr = requireActivity().getSharedPreferences("MyPref", MODE_PRIVATE)
        var edit = shr.edit();
        edit.putString("name", "$j1");
        edit.commit()
    }


    fun getShr(): String? {
        var shr = requireActivity().getSharedPreferences("MyPref", MODE_PRIVATE)
        var data = shr.getString("name", null)
        //  name_binss.text = data
        return data;

    }


    @SuppressLint("ResourceAsColor")
    fun incomeExpenceCount(list: ArrayList<ModelData>) {
        var i = 0;
        while (i < list.size) {
            if (list[i].type.equals("0")) {
                incomeTotal = incomeTotal + list[i].taka.toInt()

            } else {
                expTotal = expTotal + list[i].taka.toInt()
            }
            i++
//            Toast.makeText(activity,"$incomeTotal",Toast.LENGTH_SHORT).show()

        }




        txt1Income.text = incomeTotal.toString()
        txt3Expence.text = expTotal.toString()

//        if (expTotal.toInt() == 0) {
//
//            binding11.txtExp.text = "0"
//
//        } else {
//            binding11.txtExp.text = (incomeTotal - expTotal).toString()
//        }
//        if (incomeTotal > expTotal) {
//            binding11.txtExp.setTextColor(Color.parseColor("#0F814D"))
//        } else if (incomeTotal < expTotal) {
//            binding11.txtExp.setTextColor(Color.parseColor("#DF1837"))
//        }


    }


    override fun onResume() {
        incomeTotal = 0
        expTotal = 0
        super.onResume()
        var db = DB_Helper(mainActivity)
        this.list = db.readData()
        size = list.size

        try {
            incomeExpenceCount(list)
        } catch (e: Exception) {
        }
        viewmodel.setList(list)
        setUpRv(list)


    }

    fun setUpRv(l1: List<ModelData>) {
        var adpter = New_Contect_Adpter(mainActivity, l1)
        var lm = LinearLayoutManager(mainActivity)
        recycle_view_home.layoutManager = lm
        recycle_view_home.adapter = adpter

    }

}