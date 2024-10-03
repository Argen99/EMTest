package com.example.core_ui.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openLink(link: String) {
    var url = link
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "http://$url"
    }
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
}