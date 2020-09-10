package mz.co.bilheteira.afghangirl.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mz.co.bilheteira.afghangirl.data.model.AfghanGirl
import mz.co.bilheteira.afghangirl.databinding.AfghanGirlItemBinding

class HomeAdapter(private val list: List<AfghanGirl>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AfghanGirlItemBinding.inflate(inflater)
        return HomeViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(items = list[position])

    override fun getItemCount(): Int = list.size

    inner class HomeViewHolder(val binding: AfghanGirlItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: AfghanGirl) {
            binding.afghanGirl = items
        }
    }
}