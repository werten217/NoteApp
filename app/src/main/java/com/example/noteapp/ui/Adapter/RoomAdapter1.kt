package com.example.noteapp.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.models.NoteModel
import com.example.noteapp.databinding.ItemNoteBinding

class RoomAdapter1 : ListAdapter<NoteModel, RoomAdapter1.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
      fun bind(item: NoteModel) {
          binding.txtTitle.text = item.title
          binding.txtDescription.text = item.description

    }}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    class DiffCallback : DiffUtil.ItemCallback<NoteModel>(){
        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }


    }


}