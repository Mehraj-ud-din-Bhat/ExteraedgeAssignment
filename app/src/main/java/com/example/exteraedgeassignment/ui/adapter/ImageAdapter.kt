package com.example.exteraedgeassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.exteraedgeassignment.data.local.entity.FlickerImageEntity
import com.example.exteraedgeassignment.data.local.entity.Rocket
import com.example.exteraedgeassignment.data.remote.models.RocketModel
import com.example.exteraedgeassignment.databinding.CardRocketBinding
import com.example.exteraedgeassignment.databinding.ImageItemBinding
import com.example.exteraedgeassignment.utils.Glide

class ImageAdapter(val list: java.util.ArrayList<FlickerImageEntity>)  : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {



    class  ImageViewHolder(val  binding:ImageItemBinding):ViewHolder(binding.root){
          fun bind(image: FlickerImageEntity)
          {

              Glide.glideFetch(image.ImageUrl, "", binding.imageI)

          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return  list.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])

    }
}