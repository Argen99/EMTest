package com.example.core_ui.extesions

fun Boolean.ifTrue(action: () -> Unit) {
    if (this) action()
}

