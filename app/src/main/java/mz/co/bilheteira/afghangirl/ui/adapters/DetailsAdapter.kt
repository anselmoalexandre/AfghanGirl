package mz.co.bilheteira.afghangirl.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_users_photos.view.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl

class DetailsAdapter(private val list: List<AfghanGirl>) :
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val ui =
            LayoutInflater.from(parent.context).inflate(R.layout.item_users_photos, parent, false)
        return DetailsViewHolder(ui = ui)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        Picasso.get().load(list[position].urls.regular).into(holder.photo)
        Picasso.get().load(list[position].user.profile_image.small).into(holder.avatar)
        holder.userName.text = list[position].user.name
    }

    override fun getItemCount(): Int = list.size

    class DetailsViewHolder(ui: View) : RecyclerView.ViewHolder(ui) {
        val photo: ShapeableImageView = ui.afghanGirlPhoto
        val avatar: CircleImageView = ui.afghanGirlUserAvatar
        val userName: MaterialTextView = ui.afghanGirlUser
    }
}