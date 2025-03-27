package com.example.noteapp.ui.Adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragment.OnBoardPageFragment
import com.example.noteapp.ui.models.OnBoardModel

class OnBoardPageAdapter(private var list: List<OnBoardModel>, private val fragment: Fragment) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = 3


    override fun createFragment(position: Int): Fragment = OnBoardPageFragment().apply {
        val bundle = Bundle()
        bundle.putSerializable("Werten", list[position])
        arguments = bundle

    }
}