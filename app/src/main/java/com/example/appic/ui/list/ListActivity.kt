package com.example.appic.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appic.R

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

    }

    override fun onStart() {
        super.onStart()

        val account = Bundle()
        val brand = Bundle()
        val location = Bundle()
        val accountList = intent.extras!!.getStringArrayList("accountList")
        val brandList = intent.extras!!.getStringArrayList("brandList")
        val locationList = intent.extras!!.getStringArrayList("locationList")

        when (intent.extras!!.getString("isFrom")) {
            "account" -> {
                account.putStringArrayList("accountsNoList", accountList)
                account.putString("isItFrom", "account")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ListFragment(account)).commit()
            }
            "brand" -> {
                brand.putStringArrayList("brandNameList", brandList)
                brand.putString("isItFrom", "brand")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ListFragment(brand)).commit()
            }
            "location" -> {
                location.putStringArrayList("locationNameList", locationList)
                location.putString("isItFrom", "location")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ListFragment(location)).commit()
            }
        }
    }
}