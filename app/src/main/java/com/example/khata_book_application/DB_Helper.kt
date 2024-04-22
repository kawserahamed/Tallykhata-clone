package com.example.khata_book_application


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.khata_book_application.Fragment.ModelData

class DB_Helper(
    val context: Context?,

    ) : SQLiteOpenHelper(context, "JENISH.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {

        var quary =
            "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mobile TEXT,ruppes TEXT,type TEXT,time TEXT,date TEXT)"
        db!!.execSQL(quary)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    fun insertData(name1: String, mobile1: String, ruppes: String, type: String,time : String,date:String) {

        var db = writableDatabase

        var cv = ContentValues()

        cv.put("name", name1)
        cv.put("mobile", mobile1)
        cv.put("ruppes", ruppes)
        cv.put("type", type)
        cv.put("time", time)
        cv.put("date", date)


        var res = db.insert("student", null, cv)

        println(res)

    }


    @SuppressLint("Range")

    fun readData(): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()
        var db = readableDatabase
//        var query="SELECT * FROM student WHERE std = $value"
        var query = "SELECT * FROM student"

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {

                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var ruppes = cursor.getString(cursor.getColumnIndex("ruppes"))
                var type = cursor.getString(cursor.getColumnIndex("type"))
                var time = cursor.getString(cursor.getColumnIndex("time"))
                var date = cursor.getString(cursor.getColumnIndex("date"))


                var m1 = ModelData(id, name, mobile, ruppes, type,time,date)

                list.add(m1)


            } while (cursor.moveToNext())

        }

        return list
    }


    fun DelateData(id: String) {

        var db = writableDatabase
        db.delete("student", "id = $id", null)

//        Toast.makeText(context,"hi",Toast.LENGTH_LONG).show()

    }

    fun UpdateData(id: String, name1: String, mobile1: String, ruppes: String) {

        var db = writableDatabase

        var cv = ContentValues()

        cv.put("name", name1)
        cv.put("mobile", mobile1)
        cv.put("ruppes", ruppes)
76

        db.update("student", cv, "id = $id", null)
        Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()

    }


    @SuppressLint("Range")
    fun readData1(stas1: String): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()
        var db = readableDatabase
        var query = "SELECT * FROM student WHERE type = $stas1"
//        var query = "SELECT * FROM student"

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {

                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var ruppes = cursor.getString(cursor.getColumnIndex("ruppes"))
                var type = cursor.getString(cursor.getColumnIndex("type"))
                var time = cursor.getString(cursor.getColumnIndex("time"))
                var date = cursor.getString(cursor.getColumnIndex("date"))


                var m1 = ModelData(id, name, mobile, ruppes, type, time, date)

                list.add(m1)


            } while (cursor.moveToNext())

        }

        return list
    }


}