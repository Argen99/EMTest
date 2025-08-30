package com.example.core_ui.extesions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrlImage(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}