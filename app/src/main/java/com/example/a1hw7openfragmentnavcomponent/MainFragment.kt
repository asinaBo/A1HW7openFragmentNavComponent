package com.example.a1hw7openfragmentnavcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.a1hw7openfragmentnavcomponent.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private lateinit var adapter: MainAdpater

    private var songsArrayList = ArrayList<TrackList>()

    lateinit var imageId: Array<Int>
    lateinit var song: Array<String>
    lateinit var singer: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()

        adapter = MainAdpater(songsArrayList, this::onItemClick)
        binding.rcViewMain.adapter = adapter



    }


    private fun dataInit() {
        songsArrayList = arrayListOf<TrackList>()

       imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,


            )

        song = arrayOf(
            getString(R.string.song1),
            getString(R.string.song2),
            getString(R.string.song3),
            getString(R.string.song4),
            getString(R.string.song5),
            getString(R.string.song6),
            getString(R.string.song7),
            getString(R.string.song8),
            getString(R.string.song9),
            getString(R.string.song10),
            getString(R.string.song11),
            getString(R.string.song12),
            getString(R.string.song13),
        )
        singer = arrayOf(
            getString(R.string.singer1),
            getString(R.string.singer2),
            getString(R.string.singer3),
            getString(R.string.singer4),
            getString(R.string.singer5),
            getString(R.string.singer6),
            getString(R.string.singer7),
            getString(R.string.singer8),
            getString(R.string.singer9),
            getString(R.string.singer10),
            getString(R.string.singer11),
            getString(R.string.singer12),
            getString(R.string.singer13),
        )
        for (i in imageId.indices) {
            val songs = TrackList(imageId[i], song[i], singer[i])
            songsArrayList.add(songs)

        }

    }

    private fun onItemClick(songs: TrackList) {

        findNavController().navigate(R.id.detailFragment, bundleOf(BundleKeys.KEY_FOR_USER to songs))


    }

}