package com.babak.firstexam

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.babak.firstexam.databinding.TodoCardBinding

class CardAdapter() :
    RecyclerView.Adapter<CardAdapter.NameViewHolder>() {
    val listCard= arrayListOf<Todo>()
    inner class NameViewHolder(val todoCardBinding: TodoCardBinding) :
        RecyclerView.ViewHolder(todoCardBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = TodoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCard.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val datam = listCard[position]
        holder.todoCardBinding.todoCardName.text = datam.name
        when (datam.level) {
            1 -> holder.todoCardBinding.cardImage.setImageResource(
                R.drawable.green
            )

            2 -> holder.todoCardBinding.cardImage.setImageResource(R.drawable.red)
            3 -> holder.todoCardBinding.cardImage.setImageResource(R.drawable.yellow)
        }
        if (datam.lastDay) {
            holder.todoCardBinding.lastDayText.text = "Son Gun!!!"
        }else{
            holder.todoCardBinding.lastDayText.text =""
        }

        holder.todoCardBinding.clCard.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(todo = datam))
        }

        holder.todoCardBinding.deleteBtn.setOnClickListener {
            listCard.remove(listCard[position])
            notifyDataSetChanged()
        }
    }


    fun updateTaskList(newtasklist:ArrayList<Todo>){
        listCard.clear()
        listCard.addAll(newtasklist)
        notifyDataSetChanged()
    }


}