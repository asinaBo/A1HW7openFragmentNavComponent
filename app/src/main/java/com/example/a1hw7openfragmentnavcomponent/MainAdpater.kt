package com.example.a1hw7openfragmentnavcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.a1hw7openfragmentnavcomponent.databinding.ItemListBinding

class MainAdpater(

    private val songList: ArrayList<TrackList>,
    private  val onItemClick: (TrackList)->Unit
): Adapter< MainAdpater.ViewHolder> (){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(songList[position])

    }

    override fun getItemCount(): Int {
        return songList.size

    }


    inner class ViewHolder(private val binding:ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(songs: TrackList){
            binding.imgMain.setImageResource(songs.imageId)
            binding.tvSong.text= songs.songName
            binding.tvSinger.text = songs.singerName
            itemView.setOnClickListener {
                itemView.setOnClickListener{
                    onItemClick(songs)

                }
            }


        }
    }




}