package com.example.recyler_view_1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyler_view_1.R

class FRagmen_RV_1 : Fragment() {

    companion object {
        fun newInstance() = FRagmen_RV_1()
    }

    private lateinit var viewModel: FRagmenRV1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_f_ragmen__r_v_1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FRagmenRV1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}