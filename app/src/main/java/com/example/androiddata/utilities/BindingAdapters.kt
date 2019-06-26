package com.example.androiddata.utilities

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.NumberFormat

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("price")
fun itemPrice(view: TextView, value: Double) {
    val formatter = NumberFormat.getCurrencyInstance()
    val text = "${formatter.format(value)} / each"
    view.text = text
}