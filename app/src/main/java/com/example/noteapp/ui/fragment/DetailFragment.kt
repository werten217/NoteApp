package com.example.noteapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.data.models.NoteModel
import com.example.noteapp.databinding.FragmentDetailBinding
import com.example.noteapp.databinding.FragmentNoteBinding


class DetailFragment : Fragment() {
   private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener()= with(binding) {
        btnReady.setOnClickListener{
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            App.appDatabase?.noteDao()?.insert(NoteModel(title,description))
            findNavController().navigateUp()
        }

    }
}
