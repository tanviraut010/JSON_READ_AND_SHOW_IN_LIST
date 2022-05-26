package com.example.appic

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appic.data.DataResponse
import com.example.appic.ui.list.ListActivity
import com.example.appic.ui.utils.Utils
import com.google.gson.Gson
import java.lang.reflect.InvocationTargetException


class MainActivity : AppCompatActivity() {

    private var dataList: DataResponse? = null
    private var accountList: ArrayList<String> = arrayListOf()
    private var brandList: ArrayList<String> = arrayListOf()
    private var locationList: ArrayList<String> = arrayListOf()
    private var tvTotalAccounts: TextView? = null
    private var tvTotalBrands: TextView? = null
    private var tvTotalLocations: TextView? = null
    private var tvSelectAccount: TextView? = null
    private var tvSelectBrand: TextView? = null
    private var tvSelectLocation: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readJson()
        tvTotalAccounts = findViewById(R.id.tvTotalAccounts)
        tvTotalBrands = findViewById(R.id.tvTotalBrands)
        tvTotalLocations = findViewById(R.id.tvTotalLocations)
        tvSelectAccount = findViewById(R.id.tvSelectAccNo)
        tvSelectBrand = findViewById(R.id.tvSelectBrand)
        tvSelectLocation = findViewById(R.id.tvSelectLocation)

        init()
    }


    private fun init() {
        dataList!!.filterData?.get(0)!!.hierarchy?.forEach { hierarchy ->
            accountList.add(hierarchy.accountNumber!!)
            hierarchy.brandNameList?.forEach { brand ->
                brandList.add(brand.brandName!!)
                brand.locationNameList?.forEach { location ->
                    locationList.add(location.locationName!!)
                }
            }
        }

        val intent = Intent(this, ListActivity::class.java)

        tvSelectAccount?.setOnClickListener {
            intent.putStringArrayListExtra("accountList", accountList)
            intent.putExtra("isFrom", "account")
            startActivity(intent)
        }
        tvSelectBrand?.setOnClickListener {
            intent.putStringArrayListExtra("brandList", brandList)
            intent.putExtra("isFrom", "brand")
            startActivity(intent)
        }
        tvSelectLocation?.setOnClickListener {
            intent.putStringArrayListExtra("locationList", locationList)
            intent.putExtra("isFrom", "location")
            startActivity(intent)
        }
        tvTotalAccounts?.text =
            getString(R.string.total_accounts) + " " + accountList.size.toString()
        tvTotalBrands?.text = getString(R.string.total_brands) + " " + brandList.size.toString()
        tvTotalLocations?.text =
            getString(R.string.total_location) + " " + locationList.size.toString()
    }

    private fun readJson() {
        try {
            val gson = Gson()
            dataList = gson.fromJson(
                Utils.assetJSONFile("data.json", this),
                DataResponse::class.java
            )
        } catch (e: Exception) {
            e.printStackTrace()
        } catch (iv: InvocationTargetException) {
            iv.printStackTrace()
        }
    }
}