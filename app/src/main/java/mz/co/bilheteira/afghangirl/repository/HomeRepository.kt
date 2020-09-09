package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.model.AfghanGirl
import retrofit2.Response

interface HomeRepository {
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
        page: Int = 1,
        per_page: Int = 10,
        order_by: String = "latest"
    ): Response<List<AfghanGirl>>
}