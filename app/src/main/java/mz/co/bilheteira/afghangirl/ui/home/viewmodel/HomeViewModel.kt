package mz.co.bilheteira.afghangirl.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mz.co.bilheteira.afghangirl.model.AfghanGirl
import mz.co.bilheteira.afghangirl.repository.HomeRepositoryImpl
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class HomeViewModel(private val repository: HomeRepositoryImpl) : ViewModel() {

    // Mutable Live Data to observe Afghan girl photos
    private val photos: MutableLiveData<Resource<List<AfghanGirl>>> = MutableLiveData()

    /**
     * Launch network request inside a coroutine using viewModel Scope
     *
     */
    fun getPhotos(client_id: String, page: Int = 1, per_page: Int, order_by: String = "latest") =
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