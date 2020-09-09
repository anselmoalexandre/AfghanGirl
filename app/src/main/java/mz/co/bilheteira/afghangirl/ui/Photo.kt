package mz.co.bilheteira.afghangirl.ui

import android.content.Context
import androidx.fragment.app.Fragment
import mz.co.bilheteira.afghangirl.Main
import mz.co.bilheteira.afghangirl.R

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class Photo : Fragment(R.layout.fragment_photo) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as Main).hideBottomNav()
    }

    override fun onDetach() {
        super.onDetach()
        (activity as Main).showBottomNav()
    }
}