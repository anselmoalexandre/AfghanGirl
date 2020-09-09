package mz.co.bilheteira.afghangirl.network

import retrofit2.http.GET

interface AfghanGirlService {
    @GET("/photos")
    suspend fun getPhotos(page: Int = 1, per_page: Int = 10, order_by: String = "latest")
}