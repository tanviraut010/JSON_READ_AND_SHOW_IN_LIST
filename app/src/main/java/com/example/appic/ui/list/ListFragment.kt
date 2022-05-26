package com.example.appic.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appic.R
import com.example.appic.ui.adapter.AccountAdapter
import com.example.appic.ui.adapter.BrandAdapter
import com.example.appic.ui.adapter.LocationAdapter

class ListFragment(val bundle: Bundle) : Fragment() {

    private var accountList: ArrayList<String> = arrayListOf()
    private var brandList: ArrayList<String> = arrayListOf()
    private var locationList: ArrayList<String> = arrayListOf()
    private var accountAdapter: AccountAdapter? = null
    private var brandAdapter: BrandAdapter? = null
    private var locationAdapter: LocationAdapter? = null
    private var rvList: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        rvList = view.findViewById(R.id.rvList)


        return view
    }

    override fun onStart() {
        super.onStart()
        when (bundle.getString("isItFrom")) {
            "account" -> {
                accountList = bundle.getStringArrayList("accountsNoList") as ArrayList<String>
                accountAdapter = AccountAdapter(accountList)
                rvList?.adapter = accountAdapter
            }
            "brand" -> {
                brandList = bundle.getStringArrayList("brandNameList") as ArrayList<String>
                brandAdapter = BrandAdapter(brandList)
                rvList?.adapter = brandAdapter
            }
            "location" -> {
                locationList = bundle.getStringArrayList("locationNameList") as ArrayList<String>
                locationAdapter = LocationAdapter(locationList)
                rvList?.adapter = locationAdapter
            }
        }
    }
}