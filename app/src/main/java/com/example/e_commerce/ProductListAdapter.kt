package com.example.e_commerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ProductListAdapter(private var productsList: ArrayList<ProductDetail>) :
    RecyclerView.Adapter<ProductListAdapter.ProductsViewHolder>() {


    //First Step
    override fun getItemCount() = productsList.size


    //Step 2 - ViewHolder class
    class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val productNameTextView: TextView
        val productPriceTextView: TextView
        val productImageView: ImageView

        init {
            productNameTextView = view.findViewById(R.id.product_tv)
            productPriceTextView = view.findViewById(R.id.productAmount_tv)
            productImageView = view.findViewById(R.id.product_iv)
        }

    }


    //Step 3 returns View Holder class
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list, parent, false)

        return ProductsViewHolder(view)
    }


    //Final step - UI DATA map -> draw
    override fun onBindViewHolder(holder: ProductListAdapter.ProductsViewHolder, position: Int) {

        val product = productsList[position]

        holder.productNameTextView.text = product.title
        holder.productPriceTextView.text = product.price.toString()


        Picasso.get()
            .load(product.image)
            .resize(150, 150)
            .centerInside()
            .into(holder.productImageView) //image

        Picasso.get().isLoggingEnabled = true


    }


    // Method to update the list and notify the adapter
    fun updateProduct(newItemList: ArrayList<ProductDetail>) {
        productsList = newItemList
        notifyDataSetChanged() // Notify that the data has changed
    }


}