package mz.co.bilheteira.afghangirl.ui

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import mz.co.bilheteira.afghangirl.Main
import mz.co.bilheteira.afghangirl.R

class Home : Fragment(R.layout.fragment_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This method show tells the AppBar that this destination has a menu item
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToPhoto = view.findViewById<MaterialButton>(R.id.button_to_photos)
        buttonToPhoto.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_PhotoFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }
}