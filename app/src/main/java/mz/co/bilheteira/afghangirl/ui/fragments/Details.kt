package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.progress_bar.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.adapters.DetailsAdapter
import mz.co.bilheteira.afghangirl.ui.viewmodel.DetailsViewModel
import mz.co.bilheteira.afghangirl.util.Resource
import mz.co.bilheteira.recyclerviewgesturedetector.RecyclerviewGestureDetector
import mz.co.bilheteira.recyclerviewgesturedetector.listener.OnTouchListener

@AndroidEntryPoint
class Details : Fragment(R.layout.fragment_details) {
    // Details view model
    private val viewModel: DetailsViewModel by viewModels()

    // Args
    private val args: DetailsArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val collectionId: String = args.collectionId

        // Load photos
        viewModel.getCollectionPhotos(
            client_id = "4Do3EYsddZlw4MGyesEVwP53wMeR8sl_hlcXIcA7o6g",
            id = collectionId
        )

        // Observe changes
        viewModel.details.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    // Show progress bar
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE

                    // Handle the response data
                    response.data?.let { listOfCollectionPhotos ->
                        val adp = DetailsAdapter(list = listOfCollectionPhotos)

                        recyclerviewDetails.apply {
                            adapter = adp
                            layoutManager =
                                LinearLayoutManager(requireActivity().applicationContext)

                            addOnItemTouchListener(
                                RecyclerviewGestureDetector(
                                    context = requireContext(),
                                    recycler = recyclerviewDetails,
                                    object : OnTouchListener {
                                        /**
                                         * On Single Touch Intercept event
                                         * [view] Clicked view
                                         * [position] Clicked position of the view
                                         */
                                        override fun onSingleClick(view: View, position: Int) {
                                            // Safe Args
                                            val directions: NavDirections =
                                                DetailsDirections.actionFragmentDetailsToFragmentPhoto(
                                                    photoId = listOfCollectionPhotos[position].id
                                                )

                                            // Navigate
                                            if (findNavController().currentDestination?.id == R.id.destination_details)
                                                findNavController().navigate(directions)
                                        }


                                        override fun onLongClick(view: View, position: Int) {}
                                        override fun onDoubleClick(view: View, position: Int) {}
                                    })
                            )
                        }
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