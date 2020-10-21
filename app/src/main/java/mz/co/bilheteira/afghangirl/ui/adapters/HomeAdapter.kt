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


class HomeAdapter(private val list: List<AfghanGirl>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val ui =
            LayoutInflater.from(parent.context).inflate(R.layout.item_users_photos, parent, false)
        return HomeViewHolder(ui = ui)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        Picasso.get().load(list[position].urls.regular).into(holder.photo)
        Picasso.get().load(list[position].user.profile_image.medium).into(holder.avatar)
        holder.userName.text = list[position].user.name
    }

    override fun getItemCount(): Int = list.size

    class HomeViewHolder(ui: View) : RecyclerView.ViewHolder(ui) {
        val photo: ShapeableImageView = ui.afghanGirlPhoto
        val avatar: CircleImageView = ui.afghanGirlUserAvatar
        val userName: MaterialTextView = ui.afghanGirlUser
    }
}