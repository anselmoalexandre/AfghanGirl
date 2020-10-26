package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.Collections
import retrofit2.Response

interface ExploreRepository {

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
}