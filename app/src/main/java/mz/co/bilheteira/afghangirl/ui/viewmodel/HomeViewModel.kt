package mz.co.bilheteira.afghangirl.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.repository.HomeRepository
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class HomeViewModel @ViewModelInject constructor(private val repository: HomeRepository) :
    ViewModel() {

    // Mutable Live Data to observe Afghan girl photos
    private val photos: MutableLiveData<Resource<List<AfghanGirl>>> = MutableLiveData()
    val _photos: MutableLiveData<Resource<List<AfghanGirl>>>
        get() = photos

    /**
     * Launch network request inside a coroutine using viewModel Scope
     * [client_id] Your Access key here
     * [page] Page number to retrieve, default = 1
     * [per_page] Number of photos per page, default = 10
     * [order_by] How to sort the photos. Valid options are: latest, oldest, popular. Default is latest
     */
    fun getPhotos(
        client_id: String,
        page: Int = 1,
        per_page: Int = 10,
        order_by: String = "latest"
    ) =
        viewModelScope.launch {
            // Update the state
            photos.postValue(Resource.Loading())
            try {
                // Make a network call
                val agPhotos = repository.getPhotos(
                    client_id = client_id,
                    page = page,
                    per_page = per_page,
                    order_by = order_by
                )
                // Good, now update the observer
                photos.postValue(handlePhotosResponse(response = agPhotos))
            } catch (t: Throwable) {
                // Log the exception
                Log.d("TAG:", t.toString())
                // Update the request state
                photos.postValue(Resource.Error(message = t.message))
            }
        }

    /**
     * Handle the HTTP response
     * [response] API response
     * [AfghanGirl] List of photos
     */
    private fun handlePhotosResponse(response: Response<List<AfghanGirl>>): Resource<List<AfghanGirl>> {
        if (response.isSuccessful) {
            response.body()?.let { listOfPhotos ->
                return Resource.Success(data = listOfPhotos)
            }
        }
        return Resource.Error(message = response.message())
    }
}