package com.example.recyler_view_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyler_view_1.R
import com.example.recyler_view_1.adapters.AleacionesAdapter
import com.example.recyler_view_1.entities.Aleaciones
import androidx.navigation.Navigation

class FRagmen_RV_1 : Fragment() {
    lateinit var v : View
    lateinit var aleacioneslist: MutableList<Aleaciones>
    lateinit var recycleAleaciones : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var RecipeListAdapter: AleacionesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_f_ragmen__r_v_1,container, false)
        aleacioneslist = mutableListOf(Aleaciones(" "," ", mutableListOf(" ")))
        aleacioneslist.clear()

        aleacioneslist.add(Aleaciones("Acero", "https://serycoin.com/wp-content/uploads/2020/07/acero-construccion-Serycoin.jpg", mutableListOf("Carbono","Hierro")))
        aleacioneslist.add(Aleaciones("Alnico", "", mutableListOf("Colbato","Aluminio","Níquel","También puede contener:","Cobre","Titanio","Hierro")))
        aleacioneslist.add(Aleaciones("Alpaca", "", mutableListOf("Zinc","Cobre","Níquel")))
        aleacioneslist.add(Aleaciones("Bronce", "", mutableListOf("Cobre","Estaño")))
        aleacioneslist.add(Aleaciones("Constantán", "", mutableListOf("Cobre","Níquel")))

        recycleAleaciones = v.findViewById(R.id.recycler)

        recycleAleaciones.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recycleAleaciones.layoutManager = linearLayoutManager

        RecipeListAdapter = AleacionesAdapter(aleacioneslist,requireContext()){ pos->
            onItemClick(pos)
        }

        recycleAleaciones.adapter = RecipeListAdapter
        return v
    }
    fun onItemClick ( position : Int)  {
        var action = FRagmen_RV_1Directions.actionFRagmenRV1ToInfoFragment2(aleacioneslist[position].nombre,aleacioneslist[position].url,aleacioneslist[position].ingredientes.toTypedArray()
        )
        Navigation.findNavController(v).navigate(action)
    }

    override fun onStart(){
        super.onStart()

    }
}