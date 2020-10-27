package mz.co.bilheteira.afghangirl.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_explore.view.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.data.model.Collections

class ExploreAdapter(private val list: List<Collections>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
        return ExploreViewHolder(ui = view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        Picasso.get().load(list[position].cover_photo.urls.small).into(holder.photo)
        holder.title.text = list[position].title
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int = list.size

    class ExploreViewHolder(ui: View) : RecyclerView.ViewHolder(ui) {
        val photo: ShapeableImageView = ui.afghanGirlExplorePhoto
        val title: MaterialTextView = ui.afghanGirlExploreTitle
    }
}