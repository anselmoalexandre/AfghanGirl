package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.progress_bar.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.adapters.HomeAdapter
import mz.co.bilheteira.afghangirl.ui.viewmodel.HomeViewModel
import mz.co.bilheteira.afghangirl.util.Resource
import mz.co.bilheteira.recyclerviewgesturedetector.RecyclerviewGestureDetector
import mz.co.bilheteira.recyclerviewgesturedetector.listener.OnTouchListener

@AndroidEntryPoint
class Home : Fragment(R.layout.fragment_home) {

    // Home View Model
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This method show tells the AppBar that this destination has a menu item_users_photos
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe photos
        viewModel.getPhotos("4Do3EYsddZlw4MGyesEVwP53wMeR8sl_hlcXIcA7o6g")
        viewModel._photos.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Loading -> {
                    // Show progress bar
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE
                    response.data?.let { listOfItems ->
                        val adp = HomeAdapter(list = listOfItems)
                        homeRecyclerView.apply {
                            adapter = adp

                            layoutManager =
                                LinearLayoutManager(requireActivity().applicationContext)

                            addOnItemTouchListener(
                                RecyclerviewGestureDetector(
                                    context = requireContext(),
                                    recycler = homeRecyclerView,
                                    listener = object : OnTouchListener {
                                        override fun onSingleClick(view: View, position: Int) {
                                            Toast.makeText(
                                                requireContext(),
                                                "item on $position",
                                                Toast.LENGTH_SHORT
                                            ).show()
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
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }
}