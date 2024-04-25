package com.example.khata_book_application

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.khata_book_application.Fragment.ModelData
import java.util.Locale

class DBViewModel(application: Application) : AndroidViewModel(application) {
    var db = DB_Helper(application)
    private val originalList = db.readData()
    private val filteredList = MutableLiveData<List<ModelData>>()

    fun getFilteredList(): MutableLiveData<List<ModelData>> {
        return filteredList
    }

    fun setList(list: List<ModelData>) {
        originalList.clear()
        originalList.addAll(list)
    }

    fun filter(query: String?) {
        val queryString = query?.lowercase(Locale.getDefault())
        filteredList.value = originalList.filter {
            val query = queryString.orEmpty().lowercase(Locale.getDefault())
            it.name.lowercase(Locale.getDefault()).contains(query) || it.mobile.lowercase(
                Locale.getDefault()
            ).contains(query)
        }
    }


}