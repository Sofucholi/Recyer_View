package com.example.recyler_view_1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.recyler_view_1.R
import com.example.recyler_view_1.entities.Usuario
import com.example.recyler_view_1.viewModel.RegisterViewModel

class RegisterFragment : Fragment() {
    lateinit var v: View
    lateinit var btnRegistro: Button
    lateinit var usuariosList: MutableList<Usuario>
    lateinit var nombreEdttxt: EditText
    lateinit var contrasenaEdttxt: EditText

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_register, container, false)
        btnRegistro = v.findViewById(R.id.registrarseBtn)

        nombreEdttxt = v.findViewById(R.id.UsuarioTxt)
        contrasenaEdttxt = v.findViewById(R.id.ContrasenaTxt)

        usuariosList = mutableListOf(Usuario("" ,""))


        return v
    }

    override fun onStart() {
        super.onStart()
        btnRegistro.setOnClickListener {
           var nombre = nombreEdttxt.text.toString()
            var contraseña:String = contrasenaEdttxt.text.toString()
            if (!nombre.isEmpty() && !contraseña.isEmpty()){
                var action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(nombre,contraseña)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}