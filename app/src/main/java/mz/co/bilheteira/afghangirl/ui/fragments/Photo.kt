package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.viewmodel.PhotoViewModel

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */

class Photo : Fragment(R.layout.fragment_photo) {

    // View Model
    private val viewModel: PhotoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments()

    }
}