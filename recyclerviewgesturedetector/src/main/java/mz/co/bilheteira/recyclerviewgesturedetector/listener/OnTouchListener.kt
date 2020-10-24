package mz.co.bilheteira.recyclerviewgesturedetector.listener

import android.view.View

interface OnTouchListener {
    /**
     * On Single Touch Intercept event
     * [view] Clicked view
     * [position] Clicked position of the view
     */
    fun onSingleClick(view: View, position: Int)

    /**
     * On Long Touch Intercept Event
     * [view] Clicked view
     * [position] Clicked position
     */
    fun onLongClick(view: View, position: Int)

    /**
     * On Double Touch Intercept Event
     * [view] Clicked view
     * [position] Clicked position
     */
    fun onDoubleClick(view: View, position: Int)
}