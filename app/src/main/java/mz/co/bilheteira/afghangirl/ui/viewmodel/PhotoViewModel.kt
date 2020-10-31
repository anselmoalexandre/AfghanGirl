package mz.co.bilheteira.afghangirl.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.data.model.Photo
import mz.co.bilheteira.afghangirl.repository.AfghanGirlRepository
import mz.co.bilheteira.afghangirl.util.Resource
import retrofit2.Response

class PhotoViewModel @ViewModelInject constructor(private val repository: AfghanGirlRepository) :
    ViewModel() {

    private val _photo: MutableLiveData<Resource<Photo>> = MutableLiveData()
    val photo: MutableLiveData<Resource<Photo>>
        get() = _photo

    /**
     * Get single photo
     * [client_id] Unsplash client id
     * [id] Photo id
     */
    fun getPhoto(client_id: String, id: String) = viewModelScope.launch {
        // Update the state
        _photo.postValue(Resource.Loading())
        try {
            // Make a network call
            val photo = repository.getPhoto(client_id = client_id, id = id)
            // Handle the response
            _photo.postValue(handlePhotoResponse(response = photo))
        } catch (t: Throwable) {
            // Update the request state
            _photo.postValue(Resource.Error(message = t.message))
        }
    }

    /**
     * Handle the HTTP response
     * [response] API response
     * [AfghanGirl] List of collections
     */
    private fun handlePhotoResponse(response: Response<Photo>): Resource<Photo> {
        if (response.isSuccessful) {
            response.body()?.let { photo ->
                return Resource.Success(data = photo)
            }
        }
        return Resource.Error(message = response.message())
    }
}