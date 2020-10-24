package mz.co.bilheteira.afghangirl.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.repository.ExploreRepository
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class ExploreViewModel @ViewModelInject constructor(private val exploreRepository: ExploreRepository) :
    ViewModel() {

    /**
     * Handle the HTTP response
     * [response] API response
     * [AfghanGirl] List of collections
     */
    private fun handleCollectionsResponse(response: Response<List<Collections>>): Resource<List<Collections>> {
        if (response.isSuccessful) {
            response.body()?.let { listOfCollections ->
                return Resource.Success(data = listOfCollections)
            }
        }
        return Resource.Error(message = response.message())
    }
}