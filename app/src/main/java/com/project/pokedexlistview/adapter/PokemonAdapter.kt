package com.project.pokedexlistview.adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.project.pokedexlistview.model.Pokemon
import com.project.pokedexlistview.R
import org.w3c.dom.Text

class PokemonAdapter(private val pokemonList: ArrayList<Pokemon>, private val context: Context) : BaseAdapter() {
    override fun getCount(): Int {
      return pokemonList.size
    }

    override fun getItem(position: Int): Any {
       return pokemonList[position]
    }

    override fun getItemId(position: Int): Long {
    return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var pokemonSort=""
        var view=convertView
        if (view == null) {
            val inflater=LayoutInflater.from(context)
            view=inflater.inflate(R.layout.single_row,parent,false)
        }
        val pokemonNameText=view?.findViewById<TextView>(R.id.pokemonNameText)
        val pokemonSortText=view?.findViewById<TextView>(R.id.pokemonSortText)
        val pokemonImageView=view?.findViewById<ImageView>(R.id.pokemonImageView)

        val shapeDrawable =pokemonImageView?.background as GradientDrawable
        val currentPokemon=pokemonList[position]
        pokemonNameText?.text=currentPokemon.pokemonName
        pokemonSortText?.text=currentPokemon.pokemonSort

        if (pokemonSortText !=null) {
            pokemonSort = if (  pokemonSortText.text.contains(",")){
                pokemonSortText.text.split(',').first()
            }else{
                pokemonSortText.text.toString()
            }
            shapeDrawable.setColor(getColorValueFromPokemonSort(pokemonSort,context))
        }

        pokemonImageView.setImageResource(currentPokemon.pokemonImg)
        return view
    }


}

fun getColorValueFromPokemonSort(pokemonSort:String, context: Context):Int {
    return when(pokemonSort){
        "Fire"-> ContextCompat.getColor(context, R.color.fire)
        "Water"-> ContextCompat.getColor(context, R.color.water)
        "Bug"-> ContextCompat.getColor(context, R.color.bug)
        "Normal"-> ContextCompat.getColor(context, R.color.normal)
        "Grass"-> ContextCompat.getColor(context, R.color.grass)
        else-> ContextCompat.getColor(context, R.color.black)

    }
}