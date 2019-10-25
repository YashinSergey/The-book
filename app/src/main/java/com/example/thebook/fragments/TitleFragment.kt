package com.example.thebook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.thebook.data.Constants
import com.example.thebook.adapters.CustomItemClickListener
import com.example.thebook.ui.MainActivity
import com.example.thebook.R
import com.example.thebook.adapters.TitleAdapter

import java.util.ArrayList
import io.reactivex.Single

class TitleFragment : Fragment() {

    private val TAG = "TitleFragment"

    private lateinit var titleList: ArrayList<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var activity: MainActivity

    private val clickListener: CustomItemClickListener
        get() = object : CustomItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                activity.singleTitle = Single.just(titleList[position])
                activity.replaceFragment(BodyFragment())
                Toast.makeText(activity.applicationContext, titleList[position].replace("_", " "), Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tital_fragment, container, false)
        activity = getActivity() as MainActivity
        titleList = ArrayList()

        fillTheList(titleList)

        val titleAdapter = TitleAdapter(activity.applicationContext, titleList, clickListener)

        initRecyclerView(view, titleAdapter)
        return view
    }

    private fun initRecyclerView(view: View, titleAdapter: TitleAdapter) {
        recyclerView = view.findViewById(R.id.title_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity.applicationContext)
        recyclerView.adapter = titleAdapter
    }

    private fun fillTheList(list: ArrayList<String>) {
        list.add(Constants.DEBUT_IN_ECHO)
        list.add(Constants.JUBA_CHEBOBARGO)
        list.add(Constants.PRISON_SELL)
        list.add(Constants.ALIEN)
        list.add(Constants.THE_KING_OF_BANJA)
        list.add(Constants.VICTIMS_OF_CIRCUMSTANCES)
        list.add(Constants.TRAVELING_TO_KETTARY)
    }
}
