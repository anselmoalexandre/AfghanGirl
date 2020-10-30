package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.Photo
import retrofit2.Response

interface PhotoRepository {
    /**
     * Retrieve a single photo.
     * [id] The photo’s ID. Required.
     */
    suspend fun getPhoto(client_id: String, id: String): Response<Photo>
}