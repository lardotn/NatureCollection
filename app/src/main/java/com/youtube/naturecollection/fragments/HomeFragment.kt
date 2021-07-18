package com.youtube.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.youtube.naturecollection.MainActivity
import com.youtube.naturecollection.PlantModel
import com.youtube.naturecollection.R
import com.youtube.naturecollection.adapter.PlantAdapter
import com.youtube.naturecollection.adapter.PlantItemDecoration

class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // Création de la liste pour stocker les plantes
        val plantList = arrayListOf<PlantModel>()

        // Enregistrer une première plante dans la liste
        plantList.add(PlantModel("Pissenlit","jaune soleil","https://cdn.pixabay.com/photo/2014/05/01/17/51/flower-335662_960_720.jpg",false))
        plantList.add(PlantModel("Rose","ça pique un peu","https://cdn.pixabay.com/photo/2018/05/16/22/27/rose-3407234_960_720.jpg",false))
        plantList.add(PlantModel("Cactus","ça pique beaucoup","https://cdn.pixabay.com/photo/2016/07/06/20/47/prickly-pear-1501307_960_720.jpg",false))
        plantList.add(PlantModel("Tulipe","c'est beau","https://cdn.pixabay.com/photo/2017/03/13/21/19/tulip-2141216_960_720.jpg",false))

        // Récupérer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        // Récupérer le second recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }

}