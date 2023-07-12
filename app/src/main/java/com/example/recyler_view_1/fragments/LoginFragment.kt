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
import com.example.recyler_view_1.viewModel.LoginViewModel

class LoginFragment : Fragment() {
    lateinit var v: View
    lateinit var btnIngreso: Button
    lateinit var nombreEdttxt : EditText
    lateinit var contraEdttxt : EditText
    lateinit var todosUsuarios: MutableList<Usuario>
    lateinit var u: String
    lateinit var c: String

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)
        btnIngreso = v.findViewById(R.id.ingresarBtn)

        nombreEdttxt = v.findViewById(R.id.editTextLabel)
        contraEdttxt = v.findViewById(R.id.editPassword)

        todosUsuarios = mutableListOf(Usuario(contrasena = "", nombre=""))
        todosUsuarios.clear()

        todosUsuarios.add(Usuario("Edna","Moda"))
        todosUsuarios.add(Usuario("Sofia","1234"))

        u = LoginFragmentArgs.fromBundle(requireArguments()).nombre
        c = LoginFragmentArgs.fromBundle(requireArguments()).contrasena

        if (!u.isEmpty() && !c.isEmpty()){
            todosUsuarios.add(Usuario(u,c))
        }

        return v
    }

    override fun onStart() {
        super.onStart()
        btnIngreso.setOnClickListener {
            var imputNombre = nombreEdttxt.text.toString()
            var imputContra = contraEdttxt.text.toString()
            var nombreIngresado = todosUsuarios.find {i ->i.nombre == imputNombre }
            var contraIngresada = todosUsuarios.find { i -> i.contrasena == imputContra }
            if (!imputNombre.isEmpty() && !imputContra.isEmpty()){
                if (nombreIngresado != null && contraIngresada != null){
                    var action = LoginFragmentDirections.actionLoginFragmentToFRagmenRV1()
                    Navigation.findNavController(v).navigate(action)
                }
                else{
                    nombreEdttxt.error = "Credenciales erroneas"
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}