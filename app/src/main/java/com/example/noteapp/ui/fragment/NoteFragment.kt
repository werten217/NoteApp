package com.example.noteapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.ui.Adapter.RoomAdapter1


class NoteFragment : Fragment() {
   private lateinit var binding: FragmentNoteBinding
   private val noteAdapter = RoomAdapter1()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()
    }



    private fun initialize() {
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter

        }
    }

    private fun setupListener()=with(binding) {
        btnAction.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_detailFragment)
        }
    }
    private fun getData() {
        App.appDatabase?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
    }

}}