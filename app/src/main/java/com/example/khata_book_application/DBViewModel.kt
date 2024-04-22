package com.example.khata_book_application

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khata_book_application.Fragment.ModelData
import java.util.Locale

class DBViewModel : ViewModel() {
    private val originalList = arrayListOf<ModelData>()
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