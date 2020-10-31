package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.progress_bar.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.viewmodel.PhotoViewModel
import mz.co.bilheteira.afghangirl.util.Resource

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class Photo : Fragment(R.layout.fragment_photo) {
    // Photo View Model
    private val viewModel: PhotoViewModel by viewModels()

    // Args
    private val args: PhotoArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photoId: String = args.photoId

        // Get the Photo
        viewModel.getPhoto(client_id = "4Do3EYsddZlw4MGyesEVwP53wMeR8sl_hlcXIcA7o6g", id = photoId)
        // Observe changes
        viewModel.photo.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    // Show progress bar
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE

                    // Handle the response data
                    response.data?.let { photo ->
                        Picasso.get().load(photo.urls.regular).into(afghanGirlUserPhoto)
                    }
                }
                is Resource.Error -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}