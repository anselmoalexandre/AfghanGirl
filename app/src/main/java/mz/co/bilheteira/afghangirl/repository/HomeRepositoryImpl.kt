package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Response
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val afghanGirlService: AfghanGirlService) :
    HomeRepository {
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
    ): Response<List<AfghanGirl>> {
        return afghanGirlService.getPhotos(
            client_id = client_id,
            page = page,
            per_page = per_page,
            order_by = order_by
        )
    }
}