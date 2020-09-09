package mz.co.bilheteira.afghangirl.network

import mz.co.bilheteira.afghangirl.model.AfghanGirl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AfghanGirlService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") client_id: String,
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 5,
        @Query("order_by") order_by: String = "latest"
    ): Response<AfghanGirl>
}