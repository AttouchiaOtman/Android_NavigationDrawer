package com.example.myapplication.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.Etudiant

class ListAdapter(private val context:Activity,private  val etds:ArrayList<Etudiant>):ArrayAdapter<Etudiant>(context, R.layout.list_item,etds) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        val rowView = context.layoutInflater.inflate(R.layout.list_item, null, true)
        val titleText = rowView.findViewById(R.id.nomLs) as TextView
        val subtitleText = rowView.findViewById(R.id.villeLs) as TextView
        titleText.text =  "${etds[position].nom}  ${etds[position].prenom}"
        subtitleText.text = etds[position].ville +" "+etds[position].dateNaissance
        val photo = rowView.findViewById<ImageView>(R.id.icon)
        photo.setImageURI(etds[position].photoUri)
        return rowView
    }
}