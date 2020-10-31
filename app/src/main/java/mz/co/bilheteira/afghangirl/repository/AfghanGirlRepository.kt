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
     * [client_id] Client key
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
     * [client_id] Client key
     * [id] The photo’s ID. Required.
     */
    suspend fun getPhoto(client_id: String, id: String): Response<Photo>

    /**
     * Get collection's photos
     * [client_id] Client key
     * [id] The collection’s ID. Required.
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     * [orientation] Filter by photo orientation. Optional. (Valid values: landscape, portrait, squarish)
     */
    suspend fun getCollectionPhotos(
        client_id: String,
        id: String,
        page: Int = 1,
        per_page: Int = 10,
        orientation: String
    ): Response<List<AfghanGirl>>
}