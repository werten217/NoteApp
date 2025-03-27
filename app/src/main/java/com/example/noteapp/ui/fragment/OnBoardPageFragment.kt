package com.example.noteapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardPageBinding
import com.example.noteapp.ui.models.OnBoardModel


class OnBoardPageFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val onBoardModel = arguments?.getSerializable("Werten") as? OnBoardModel

        onBoardModel?.let { model ->
            binding.titleTxt.text = model.title
            binding.descriptionTxt.text = model.description

            Glide.with(this)
                .load(model.imageView)
                .transform(RoundedCorners(20))
                .into(binding.imageView)
        }
    }
}