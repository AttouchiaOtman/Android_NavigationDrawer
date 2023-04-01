package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.myapplication.adapter.ListAdapter

import com.example.myapplication.service.EtudiantService

class ListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        val view : View = inflater.inflate(R.layout.fragment_list, container, false)
        val listAdapter = ListAdapter(requireActivity(), EtudiantService.instance!!.students)
        val listView : ListView = view.findViewById(R.id.listView)
        listView.adapter = listAdapter
        return view
    }
}