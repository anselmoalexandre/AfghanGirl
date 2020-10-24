package mz.co.bilheteira.afghangirl.data.model

data class ProfileImage(val small: String, val medium: String, val large: String)

data class User(
    val id: Int,
    val username: String,
    val name: String,
    val total_likes: Int,
    val total_photos: Int,
    val profile_image: ProfileImage
)

data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class Explore(val id: Int, val imageUrl: String, val title: String)

data class Cover(
    val id: String,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String,
    val user: User,
    val urls: Urls
)

data class Collections(
    val id: Int,
    val title: String,
    val total_photos: Int,
    val cover_photo: Cover,
)

data class AfghanGirl(
    val id: Int,
    val width: Int,
    val height: Int,
    val likes: Int,
    val description: String?,
    val user: User,
    val urls: Urls
)
