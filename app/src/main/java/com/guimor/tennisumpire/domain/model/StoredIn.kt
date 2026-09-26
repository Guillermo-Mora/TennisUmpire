package com.guimor.tennisumpire.domain.model

enum class StoredIn(
    val pathName: String,
) {
    CAMERA_CACHE(
        pathName = "camera_cache",
    ),
    PLAYER_PHOTOS(
        pathName = "player_photos",
    ),
}