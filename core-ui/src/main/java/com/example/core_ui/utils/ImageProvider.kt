package com.example.core_ui.utils

object ImageProvider {
    /**
     * Получаем случайную ссылку на изображение, так как нет в модельке
     */
    fun getRandomImageUrl(): String {
        val imageUrls = listOf(
            "https://cdn.stepik.net/media/cache/images/courses/239411/cover_WSP23HG/cca3ab5045572c7efc38561f14872028.png",
            "https://cdn.stepik.net/media/cache/images/courses/239239/cover_csbxKMe/da119a8c33e0ee25d32e5980a7600c02.jpg",
            "https://cdn.stepik.net/media/cache/images/courses/228553/cover_SNnIV8Q/4704318f63e33bf65817e35fe1d79339.png",
            "https://cdn.stepik.net/media/cache/images/courses/212519/cover_F1xvLVj/63f9dc57c9f18e81523ff4058426f6ae.jpg",
            "https://cdn.stepik.net/media/cache/images/courses/238905/cover_tTMUzoD/d64576f43929712ab95aedc8d0f6acc7.png"
        )
        return imageUrls.random()
    }
}