package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.progress_bar.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.viewmodel.HomeViewModel
import mz.co.bilheteira.afghangirl.util.Resource

@AndroidEntryPoint
class Home : Fragment(R.layout.fragment_home) {

    // View Model
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This method show tells the AppBar that this destination has a menu item
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe photos
        homeViewModel._photos.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    // Show progress bar
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE
                    response.data?.let { items ->

                    }
                }
                is Resource.Error -> {
                    // Hide progress bar
                    progressBar.visibility = View.GONE
                }
            }
        })


//        val buttonToPhoto = view.findViewById<MaterialButton>(R.id.button_to_photos)
//        buttonToPhoto.setOnClickListener {
//            findNavController().navigate(R.id.action_HomeFragment_to_PhotoFragment)
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }
}