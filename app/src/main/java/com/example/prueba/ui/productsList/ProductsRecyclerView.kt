package com.example.prueba.ui.productsList

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.prueba.data.entities.ProductModel
import com.example.prueba.databinding.ItemProductBinding

class MovieRecyclerView :  RecyclerView.Adapter<MovieViewHolder>() {

    private val items = ArrayList<ProductModel>()
    private lateinit var mContext: Context

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        mContext = parent.context
        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<ProductModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}
class MovieViewHolder(private val itemBinding: ItemProductBinding) : RecyclerView.ViewHolder(itemBinding.root){

    private lateinit var productModel: ProductModel

    @SuppressLint("SetTextI18n")
    fun bind(item: ProductModel) {
        this.productModel = item
        itemBinding.txtProductName.text = productModel.productDisplayName
        itemBinding.txtListPrice.text = productModel.listPrice.toString()
        itemBinding.txtPromoPrice.text = productModel.promoPrice.toString()
        itemBinding.imgProductImage.let {
            Glide.with(itemBinding.root)
                .load(productModel.smImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(it)
        }
    }

}