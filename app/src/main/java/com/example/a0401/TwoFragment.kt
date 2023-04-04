package com.example.a0401

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a0401.databinding.*


class TwoFragment : Fragment(){
    lateinit var binding: FragmentTwoBinding
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList>
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater)
        dataList = mutableListOf<DataList>()
        return binding.root
    }
}