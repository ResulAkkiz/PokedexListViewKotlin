package com.project.pokedexlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.project.pokedexlistview.adapter.PokemonAdapter
import com.project.pokedexlistview.databinding.ActivityMainBinding
import com.project.pokedexlistview.model.Pokemon

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pokemonList: ArrayList<Pokemon> = ArrayList<Pokemon>(20)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getResource()
        val adapter = PokemonAdapter(pokemonList,this)
        binding.pokemonListView.adapter=adapter

        binding.pokemonListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent=Intent(this,DetailActivity::class.java)
                intent.putExtra("pokemon",pokemonList[position])
                startActivity(intent)
            }

    }

    private fun getResource() {
        val pokemonName = resources.getStringArray(R.array.pokemonName)
        val pokemonType = resources.getStringArray(R.array.pokemonType)
        val pokemonImage = arrayOf<Int>(
            R.drawable.pokemon1,
            R.drawable.pokemon2,
            R.drawable.pokemon3,
            R.drawable.pokemon4,
            R.drawable.pokemon5,
            R.drawable.pokemon6,
            R.drawable.pokemon7,
            R.drawable.pokemon8,
            R.drawable.pokemon9,
            R.drawable.pokemon10,
            R.drawable.pokemon11,
            R.drawable.pokemon12,
            R.drawable.pokemon13,
            R.drawable.pokemon14,
            R.drawable.pokemon15,
            R.drawable.pokemon16,
            R.drawable.pokemon17,
            R.drawable.pokemon18,
            R.drawable.pokemon19,
            R.drawable.pokemon20
        )

        for (position in 0..19) {
            pokemonList.add(
                Pokemon(
                    pokemonName[position],
                    pokemonType[position],
                    pokemonImage[position]
                )
            )
        }
    }

}




