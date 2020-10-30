package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import mz.co.bilheteira.afghangirl.R

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */

class Photo : Fragment(R.layout.fragment_photo) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments()

    }
}