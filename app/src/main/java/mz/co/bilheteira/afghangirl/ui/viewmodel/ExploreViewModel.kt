package mz.co.bilheteira.afghangirl.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Collections
import mz.co.bilheteira.afghangirl.repository.ExploreRepository
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class ExploreViewModel @ViewModelInject constructor(private val repository: ExploreRepository) :
    ViewModel() {

    // Live data
    private val _collections: MutableLiveData<Resource<List<Collections>>> = MutableLiveData()
    val collections: MutableLiveData<Resource<List<Collections>>>
        get() = _collections

    /**
     * Get a single page from the list of all collections
     * [client_id] Client Identification
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     */
    fun getCollections(client_id: String, page: Int, per_page: Int) = viewModelScope.launch {
        // Update the state
        _collections.postValue(Resource.Loading())
        try {
            // Make a network call
            val afghanCollections = repository.getCollections(
                client_id = client_id,
                page = page,
                per_page = per_page
            )
            // Handle the response
            _collections.postValue(handleCollectionsResponse(response = afghanCollections))
        } catch (t: Throwable) {
            // Update the request state
            _collections.postValue(Resource.Error(message = t.message))
        }
    }

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