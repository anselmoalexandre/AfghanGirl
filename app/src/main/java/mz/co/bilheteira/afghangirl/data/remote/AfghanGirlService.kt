package mz.co.bilheteira.afghangirl.data.remote

import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.data.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AfghanGirlService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") client_id: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("order_by") order_by: String
    ): Response<List<AfghanGirl>>

    @GET("photos/{id}")
    suspend fun getPhoto(
        @Path("id") id: String,
        @Query("client_id") client_id: String
    ): Response<Photo>

    @GET("collections")
    suspend fun getCollections(
        @Query("client_id") client_id: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<List<Collections>>

    @GET("collections/{id}/photos")
    suspend fun getCollectionPhotos(
        @Path("id") id: String,
        @Query("client_id") client_id: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("orientation") orientation: String
    ): Response<List<AfghanGirl>>
}