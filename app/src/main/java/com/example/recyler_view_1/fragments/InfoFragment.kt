package com.example.recyler_view_1.fragments

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.recyler_view_1.R
import com.example.recyler_view_1.viewModel.InfoViewModel

class InfoFragment : Fragment() {

    lateinit var v : View
    lateinit var imagen: ImageView
    lateinit var titulo:TextView
    lateinit var ingredientes:TextView
    lateinit var t: String
    lateinit var u: String
    lateinit var i: Array<String>
    companion object {
        fun newInstance() = InfoFragment()
    }

    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment_info,container, false)
        t = InfoFragmentArgs.fromBundle(requireArguments()).titulo
        i = InfoFragmentArgs.fromBundle(requireArguments()).ingredientes
        u = InfoFragmentArgs.fromBundle(requireArguments()).url
        titulo = v.findViewById(R.id.tituloTxt)
        ingredientes = v.findViewById(R.id.ingredientes)
        imagen = v.findViewById(R.id.imagen)
        return v
    }



    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        titulo.text = t

        Glide
            .with(this)
            .load(u)
            .centerInside()
            .into(imagen);
        var s = "Ingredientes:\n"
        for (ingrediente in i.iterator()){
            s = s + ingrediente + "\n"
        }
        ingredientes.text = s
    }
}