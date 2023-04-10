package com.example.cocktailworld.ui.alcoholic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailworld.R
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.databinding.ItemAlcoholicBinding

class AlcoholicAdapter(val alcoholic: List<Drink>?) :
    RecyclerView.Adapter<AlcoholicAdapter.ViewHolder>() {

    var onItemClick: ((Drink) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAlcoholicBinding.bind(view)

        fun handleData(item: Drink?) {
            binding.id.text = item?.idDrink.toString()
            binding.drinkName.text = item?.strDrink
            Glide.with(itemView)
                .load(item?.strDrinkThumb) // image url
                .placeholder(R.color.cocktail_orange) // any placeholder to load at start
                .error(R.mipmap.ic_launcher_cocktail)  // any image in case of error
                //.override(300, 300) // resizing
                .centerCrop()
                .into(binding.avatar);
        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlcoholicAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alcoholic, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = alcoholic?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: AlcoholicAdapter.ViewHolder, position: Int) {
        holder.handleData(alcoholic?.get(position))
        holder.itemView.setOnClickListener {
            alcoholic?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}