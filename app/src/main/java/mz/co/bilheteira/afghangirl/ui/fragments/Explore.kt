package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.progress_bar.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.adapters.ExploreAdapter
import mz.co.bilheteira.afghangirl.ui.viewmodel.ExploreViewModel
import mz.co.bilheteira.afghangirl.util.Resource
import mz.co.bilheteira.recyclerviewgesturedetector.RecyclerviewGestureDetector
import mz.co.bilheteira.recyclerviewgesturedetector.listener.OnTouchListener

@AndroidEntryPoint
class Explore : Fragment(R.layout.fragment_explore) {
    // Explore View model
    private val viewModel: ExploreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Load collections
        viewModel.getCollections(client_id = "4Do3EYsddZlw4MGyesEVwP53wMeR8sl_hlcXIcA7o6g")
        // Observe collections changes
        viewModel.collections.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE

                    // Handle response
                    response.data?.let { listOfCollections ->
                        val adp = ExploreAdapter(list = listOfCollections)
                        exploreRecyclerView.apply {
                            adapter = adp

                            layoutManager =
                                LinearLayoutManager(requireActivity().applicationContext)

                            addOnItemTouchListener(
                                RecyclerviewGestureDetector(
                                    context = requireContext(),
                                    recycler = exploreRecyclerView,
                                    listener = object : OnTouchListener {
                                        override fun onSingleClick(view: View, position: Int) {
                                            // Using Safe Args to pass data between directions
                                            val directions: NavDirections =
                                                ExploreDirections.actionFragmentExploreToFragmentDetails(
                                                    collectionId = listOfCollections[position].id
                                                )
                                            // Navigate to end destination
                                            findNavController().navigate(directions)
                                        }

                                        override fun onDoubleClick(view: View, position: Int) {}
                                        override fun onLongClick(view: View, position: Int) {}
                                    })
                            )
                        }
                    }
                }
                is Resource.Error -> {
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}