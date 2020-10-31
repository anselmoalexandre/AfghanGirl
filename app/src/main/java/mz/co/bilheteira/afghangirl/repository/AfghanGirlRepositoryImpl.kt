package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.data.model.Photo
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Response
import javax.inject.Inject

class AfghanGirlRepositoryImpl @Inject constructor(private val afghanGirlService: AfghanGirlService) :
    AfghanGirlRepository {

    /**
     * Get photos
     * [client_id] Your Access key here
     * [page] Page number to retrieve, default = 1
     * [per_page] Number of photos per page, default = 10
     * [order_by] How to sort the photos. Valid options are: latest, oldest, popular. Default = latest
     * [AfghanGirl] List of photos
     */
    override suspend fun getPhotos(
        client_id: String,
        page: Int,
        per_page: Int,
        order_by: String
    ): Response<List<AfghanGirl>> = afghanGirlService.getPhotos(
        client_id = client_id,
        page = page,
        per_page = per_page,
        order_by = order_by
    )

    /**
     * Get a single page from the list of all collections
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     */
    override suspend fun getCollections(
        client_id: String,
        page: Int,
        per_page: Int
    ): Response<List<Collections>> =
        afghanGirlService.getCollections(client_id = client_id, page = page, per_page = page)

    /**
     * Retrieve a single photo.
     * [id] The photo’s ID. Required.
     */
    override suspend fun getPhoto(client_id: String, id: String): Response<Photo> =
        afghanGirlService.getPhoto(id = id, client_id = client_id)
}