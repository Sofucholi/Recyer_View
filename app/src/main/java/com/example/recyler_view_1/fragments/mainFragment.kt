package com.example.recyler_view_1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.recyler_view_1.R
import com.example.recyler_view_1.viewModel.MainViewModel

class mainFragment : Fragment() {
    lateinit var v: View
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button


    companion object {
        fun newInstance() = mainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main, container, false)
        btnLogin = v.findViewById(R.id.loginBtn)
        btnRegister = v.findViewById(R.id.registerBtn)
        return v
    }
    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener{
            var action = mainFragmentDirections.actionMainFragmentToLoginFragment()
            Navigation.findNavController(v).navigate(action)

        }
        btnRegister.setOnClickListener {
            var action = mainFragmentDirections.actionMainFragmentToRegisterFragment()
            Navigation.findNavController(v).navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}