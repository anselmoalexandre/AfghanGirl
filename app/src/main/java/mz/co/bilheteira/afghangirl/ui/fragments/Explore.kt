package mz.co.bilheteira.afghangirl.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mz.co.bilheteira.afghangirl.R

/**
 * A simple [Fragment] subclass.
 * Use the [Explore.newInstance] factory method to
 * create an instance of this fragment.
 */
class Explore : Fragment(R.layout.fragment_explore) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Here goes adapter and other staff
    }
}