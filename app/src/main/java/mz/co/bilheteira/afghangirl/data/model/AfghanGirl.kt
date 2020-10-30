package mz.co.bilheteira.afghangirl.data.model

data class Image(val small: String, val medium: String, val large: String)

data class User(
    val id: String,
    val username: String,
    val name: String,
    val total_likes: Int,
    val total_photos: Int,
    val profile_image: Image
)

data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class Exif(val make: String, val model: String, val iso: Int)

data class Location(val city: String, val country: String)

data class Photo(
    val id: String,
    val downloads: Int,
    val likes: Int,
    val description: String?,
    val exif: Exif,
    val location: Location,
    val urls: Urls,
    val user: User
)

data class Cover(
    val id: String,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String?,
    val user: User,
    val urls: Urls
)

data class Collections(
    val id: String,
    val title: String,
    val total_photos: Int,
    val cover_photo: Cover,
)

data class AfghanGirl(
    val id: String,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String?,
    val user: User,
    val urls: Urls
)
