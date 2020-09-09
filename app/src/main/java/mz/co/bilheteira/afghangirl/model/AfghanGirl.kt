package mz.co.bilheteira.afghangirl.model

data class Profile(val small: String, val medium: String, val large: String)

data class User(
    val id: String,
    val username: String,
    val name: String,
    val total_likes: Int,
    val total_photos: Int,
    val profile_image: Profile
)

data class PhotoUrl(val regular: String, val small: String, val thumb: String)

data class AfghanGirl(
    val id: String,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String?,
    val user: User,
    val urls: PhotoUrl
)
