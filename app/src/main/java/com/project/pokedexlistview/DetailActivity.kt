package com.project.pokedexlistview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.project.pokedexlistview.adapter.getColorValueFromPokemonSort
import com.project.pokedexlistview.databinding.ActivityDetailBinding
import com.project.pokedexlistview.model.Pokemon

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)


        val view = binding.root
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val pokemon = intent.extras?.getSerializable("pokemon", Pokemon::class.java)


        if (pokemon != null) {
            val pokemonSort = if (pokemon.pokemonSort.contains(",")) {
                pokemon.pokemonSort.split(',').first()
            } else {
                pokemon.pokemonSort.toString()
            }
            println(pokemonSort)
            setColorBars(pokemonSort, this)

            binding.pokemonDetailImageView.setImageResource(pokemon.pokemonImg)
            binding.pokemonNameDetailText.text = pokemon.pokemonName
            binding.pokemonSortDetailText.text = pokemon.pokemonSort
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setColorBars(pokemonSort: String, context: Context) {
        val colorID = getColorValueFromPokemonSort(pokemonSort, context)
        println("color ID: $colorID")
        window.statusBarColor = colorID
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
              colorID
            )
        )
    }
}