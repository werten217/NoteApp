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
   private var noteId: Int= -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateData()
        setupListener()
    }

    private fun updateData() {
        arguments?.let { args ->
            noteId = args.getInt("noteId", -1)
        }
        if (noteId != -1) {
            val model:NoteModel? = App.appDatabase?.noteDao()?.getNoteId(noteId)
            binding.etTitle.setText(model?.title)
            binding.etDescription.setText(model?.description)
        }
    }

    private fun setupListener()= with(binding) {
        btnReady.setOnClickListener{
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModel(title, description)
                updateNote.id = noteId
                App.appDatabase?.noteDao()?.updateNote(updateNote)
            } else {
                App.appDatabase?.noteDao()?.insert(NoteModel(title, description))
            }
            App.appDatabase?.noteDao()?.insert(NoteModel(title,description))
            findNavController().navigateUp()
        }

    }
}
