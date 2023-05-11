package com.example.recyler_view_1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyler_view_1.R

class FRagmen_RV_1 : Fragment() {
    lateinit var v : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_f_ragmen__r_v_1,container, false)
        recipelist.add(Recipe("Fideos", "descripcion de fideos1"))

        recycleRecetas = v.findViewById(R.id.recRecetas)
        return v

    }

    override fun onStart(){
        super.onStart()
    }
}