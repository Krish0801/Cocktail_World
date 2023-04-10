package com.example.cocktailworld.ui.nonAlcoholic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailworld.R
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.databinding.ItemAlcoholicBinding
import com.example.cocktailworld.databinding.ItemNonAlcoholicBinding
import com.example.cocktailworld.ui.alcoholic.AlcoholicAdapter

class NonAlcoholicAdapter(val nonAlcoholic: List<Drink>?) :
    RecyclerView.Adapter<NonAlcoholicAdapter.ViewHolder>() {

    var onItemClick: ((Drink) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemNonAlcoholicBinding.bind(view)

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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonAlcoholicAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_non_alcoholic, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = nonAlcoholic?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: NonAlcoholicAdapter.ViewHolder, position: Int) {
        holder.handleData(nonAlcoholic?.get(position))
        holder.itemView.setOnClickListener {
            nonAlcoholic?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}