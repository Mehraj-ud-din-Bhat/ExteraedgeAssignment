package com.example.exteraedgeassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.exteraedgeassignment.data.local.entity.Rocket
import com.example.exteraedgeassignment.data.remote.models.RocketModel
import com.example.exteraedgeassignment.databinding.CardRocketBinding
import com.example.exteraedgeassignment.utils.Glide

class RocketAdapter(val list: java.util.ArrayList<Rocket>,val listener:IClickListener)  : RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

  interface  IClickListener{
      fun onRocketClicked(rocket: Rocket)
  }

    class  RocketViewHolder(val  binding: CardRocketBinding):ViewHolder(binding.root){
          fun bind(rocket: Rocket)
          {
            binding.name.text=rocket.rocket!!.Name
            binding.country.text=rocket.rocket!!.Country
            binding.engineCount.text="Total Engines: "+rocket.rocket!!.EnginesCount
              Glide.glideFetch(rocket.getRocketThumbnail(), "", binding.imageI)

          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        return RocketViewHolder(CardRocketBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
      return  list.size
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener.onRocketClicked(list[position])
        }
    }
}