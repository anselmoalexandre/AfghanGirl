package mz.co.bilheteira.recyclerviewgesturedetector

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import mz.co.bilheteira.recyclerviewgesturedetector.listener.OnTouchListener

class RecyclerviewGestureDetector(
    context: Context,
    recycler: RecyclerView,
    val listener: OnTouchListener?
) : RecyclerView.OnItemTouchListener {
    private val mGestureDetector: GestureDetector

    init {
        mGestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                /**
                 * Trigger the proper Listener based on the
                 * Event Intercepted
                 */
                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    val child = recycler.findChildViewUnder(e.x, e.y)
                    if (child != null && listener != null) listener.onLongClick(
                        child,
                        recycler.getChildAdapterPosition(child)
                    )
                }

                override fun onDoubleTap(e: MotionEvent): Boolean {
                    val child = recycler.findChildViewUnder(e.x, e.y)
                    if (child != null && listener != null) listener.onDoubleClick(
                        child,
                        recycler.getChildAdapterPosition(child)
                    )
                    return false
                }
            })
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        if (child != null && listener != null && mGestureDetector.onTouchEvent(e)) listener.onSingleClick(
            child,
            rv.getChildAdapterPosition(child)
        )
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
}