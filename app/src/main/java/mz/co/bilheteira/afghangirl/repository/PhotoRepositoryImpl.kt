package mz.co.bilheteira.afghangirl.repository

import mz.co.bilheteira.afghangirl.data.model.Photo
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Response
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val afghanGirlService: AfghanGirlService) :
    PhotoRepository {

    /**
     * Retrieve a single photo.
     * [id] The photo’s ID. Required.
     */
    override suspend fun getPhoto(client_id: String, id: String): Response<Photo> =
        afghanGirlService.getPhoto(id = id, client_id = client_id)
}