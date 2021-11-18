package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)

        GlobalScope.launch {
            val result = quoteAPI.getQuotes(1)

            val quoteList = result.body()
            quoteList?.results?.forEach {
                Log.d("TAG", it.content)
            }
        }
    }
}