package com.example.exteraedgeassignment.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder


class Utils {

    companion object{
        fun getGsonParser(): Gson {

            var gson=Gson()
            val builder = GsonBuilder()
            gson = builder.create()

            return gson
        }
    }
}