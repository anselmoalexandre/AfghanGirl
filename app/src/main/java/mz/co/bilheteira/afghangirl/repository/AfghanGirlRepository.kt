package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.data.model.Photo
import retrofit2.Response

interface AfghanGirlRepository {
    /**
     * Get photos
     * [client_id] Your Access key here
     * [page] Page number to retrieve, default = 1
     * [per_page] Number of photos per page, default = 10
     * [order_by] How to sort the photos. Valid options are: latest, oldest, popular. Default = latest
     * [AfghanGirl] List of photos
     */
    suspend fun getPhotos(
        client_id: String,
        page: Int,
        per_page: Int,
        order_by: String
    ): Response<List<AfghanGirl>>

    /**
     * Get a single page from the list of all collections
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     */
    suspend fun getCollections(
        client_id: String,
        page: Int,
        per_page: Int
    ): Response<List<Collections>>

    /**
     * Retrieve a single photo.
     * [id] The photo’s ID. Required.
     */
    suspend fun getPhoto(client_id: String, id: String): Response<Photo>
}