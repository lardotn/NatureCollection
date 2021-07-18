package com.youtube.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youtube.naturecollection.MainActivity
import com.youtube.naturecollection.PlantModel
import com.youtube.naturecollection.R

class PlantAdapter(
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    // Boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Image de la plante
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById<TextView>(R.id.name_item)
        val plantDescription:TextView? = view.findViewById<TextView>(R.id.description_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupérer les informations de la plante
        val currentPlant = plantList[position]

        // Utiliser glide pour récupérer l'image à partir de son lien
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        // Mise à jour des informations de la plante
        holder.plantName?.text = currentPlant.name
        holder.plantDescription?.text = currentPlant.description
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

}