package com.example.recyler_view_1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyler_view_1.R
import com.example.recyler_view_1.adapters.RecipeAdapter
import com.example.recyler_view_1.entities.Recipe
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator

class FRagmen_RV_1 : Fragment() {
    lateinit var v : View
    lateinit var recipelist: MutableList<Recipe>
    lateinit var recycleRecetas : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var RecipeListAdapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_f_ragmen__r_v_1,container, false)
        recipelist = mutableListOf(Recipe(" "," ", mutableListOf(" ")))
        recipelist.clear()

        recipelist.add(Recipe("Fideos con salsa", "https://recetasfideos.pro/wp-content/uploads/2021/01/fideos-con-pollo-y-salsa.jpg", mutableListOf("fideos","salsa roja", "salsa blanca")))

        recycleRecetas = v.findViewById(R.id.recycler)

        recycleRecetas.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recycleRecetas.layoutManager = linearLayoutManager

        RecipeListAdapter = RecipeAdapter(recipelist,requireContext()){ pos->
            onItemClick(pos)


        }

//        mascotasListAdapter = MascotaListAdapter(mascotas)

        recycleRecetas.adapter = RecipeListAdapter
        return v

    }
    fun onItemClick ( position : Int )  {
        Snackbar.make(v,position.toString(), Snackbar.LENGTH_SHORT).show()

    }

    override fun onStart(){
        super.onStart()
    }
}