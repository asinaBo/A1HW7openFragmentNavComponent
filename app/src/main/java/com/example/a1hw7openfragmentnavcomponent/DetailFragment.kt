package com.example.a1hw7openfragmentnavcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1hw7openfragmentnavcomponent.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val song :TrackList? = arguments?.getSerializable(BundleKeys.KEY_FOR_USER) as TrackList
        binding.apply {
            song?.imageId?.let { imgDetail.setImageResource(it) }
            tvSongDetail.text= song?.songName
            tvSingerDetail.text = song?.singerName

        }


    }
}