package mz.co.bilheteira.afghangirl.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.repository.AfghanGirlRepository
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class DetailsViewModel @ViewModelInject constructor(private val repository: AfghanGirlRepository) :
    ViewModel() {

    // Details Live data
    private val _details: MutableLiveData<Resource<List<AfghanGirl>>> = MutableLiveData()
    val details: MutableLiveData<Resource<List<AfghanGirl>>>
        get() = _details

    /**
     * Get collection's photos
     * [client_id] Client key
     * [id] The collection’s ID. Required.
     * [page] Page number to retrieve. (Optional; default: 1)
     * [per_page] Number of items per page. (Optional; default: 10)
     * [orientation] Filter by photo orientation. Optional. (Valid values: landscape, portrait, squarish)
     */
    fun getCollectionPhotos(
        client_id: String,
        id: String,
        page: Int = 1,
        per_page: Int = 10,
        orientation: String = "portrait"
    ) = viewModelScope.launch {
        // Update the state
        _details.postValue(Resource.Loading())
        try {
            // Perform the network call
            val details = repository.getCollectionPhotos(
                client_id = client_id,
                id = id,
                page = page,
                per_page = per_page,
                orientation = orientation
            )
            // Handle the response
            _details.postValue(handleCollectionPhotosResponse(response = details))
        } catch (t: Throwable) {
            _details.postValue(Resource.Error(message = t.message))
        }
    }

    /**
     * Handle the HTTP response
     * [response] API response
     * [AfghanGirl] List of collection's photos
     */
    private fun handleCollectionPhotosResponse(response: Response<List<AfghanGirl>>): Resource<List<AfghanGirl>> {
        if (response.isSuccessful) {
            response.body()?.let { listOfCollectionPhotos ->
                return Resource.Success(data = listOfCollectionPhotos)
            }
        }
        return Resource.Error(message = response.message())
    }
}