package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Response
import javax.inject.Inject

class ExploreRepositoryImpl @Inject constructor(private val afghanGirlService: AfghanGirlService) :
    ExploreRepository {

    /**
     * Get a single page from the list of all collections
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     */
    override suspend fun getCollections(page: Int, per_page: Int): Response<List<Collections>> =
        afghanGirlService.getCollections(page = page, per_page = page)
}