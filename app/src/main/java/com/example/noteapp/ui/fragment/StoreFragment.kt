package com.example.noteapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentStoreBinding
import com.example.noteapp.ui.Adapter.StoreAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class StoreFragment : Fragment() {
    private lateinit var binding: FragmentStoreBinding
    private val storeAdapter = StoreAdapter()
    private val db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
binding.recyclerViewStore.apply {
    layoutManager = LinearLayoutManager(requireContext())
    adapter = storeAdapter
}
    }
    private fun setupListeners() {
        binding.btnSaveStore.setOnClickListener{
            val user = hashMapOf(
                "text" to binding.etTextStore.text.toString()
            )
            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Успешно добавлено", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                }

        }

    }
}