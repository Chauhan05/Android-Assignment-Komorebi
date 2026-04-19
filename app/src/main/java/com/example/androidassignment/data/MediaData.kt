package com.example.androidassignment.data

import com.example.androidassignment.R

data class MediaItem(
    val id: String,
    val title: String,
    val image: Int,
    val year: Int = 2024,
    val duration: String = "2h 35m",
    val genres: String = "Documentary, Biopic",
    val description: String = "Irrfan Khan was an Indian actor who worked in " +
            "Indian cinema as well as British and American films. Widely regarded as one " +
            "of the finest actors in world cinema, Khan's career spanned over 30 years " +
            "and earned him numerous accolades, including a National Film Award, an " +
            "Asian Film Award, and six Filmfare Awards.",
    val trailers: List<Trailer> = sampleTrailers
)

data class Trailer(
    val id: String,
    val title: String,
    val duration: String,
    val thumbnail: Int
)

data class MediaSection(
    val title: String,
    val items: List<MediaItem>
)

val sampleTrailers = listOf(
    Trailer("t1", "Trailer : The Vanishing of Will Byers", "2 min 13sec", R.drawable.banner_image),
    Trailer("t2", "Trailer : The Vanishing of Will Byers", "2 min 13sec", R.drawable.banner_image),
    Trailer("t3", "Trailer : The Vanishing of Will Byers", "2 min 13sec", R.drawable.banner_image),
)

object DummyData {
    val sampleItems = listOf(
        MediaItem("1", "ICELAND", R.drawable.card_1),
        MediaItem("2", "UKRAINE", R.drawable.card_1),
        MediaItem("3", "ICELAND", R.drawable.card_2),
        MediaItem("4", "PATHS", R.drawable.card_3),
        MediaItem("5", "NOLAN", R.drawable.card_4),
    )

    val sections = listOf(
//        very media section has the same list
        MediaSection("Documentaries", sampleItems),
        MediaSection("New Releases", sampleItems),
        MediaSection("Trending Now", sampleItems),
        MediaSection("Recommended", sampleItems),
        MediaSection("Filmmakers", sampleItems),
    )

    val defaultMedia = MediaItem("0", "Irrfan Khan", R.drawable.banner_image)

    // fall back for mediaitem
    fun findById(id: String): MediaItem =
        sections.flatMap { it.items }.find { it.id == id }
            ?: defaultMedia
}