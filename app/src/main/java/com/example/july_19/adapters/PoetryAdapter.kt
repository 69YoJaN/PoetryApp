package com.example.july_19.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.july_19.R
import com.example.july_19.model.Poetry
import okhttp3.internal.notify

class PoetryAdapter(private var poetry: List<Poetry>): RecyclerView.Adapter<PoetryAdapter.PoetryViewHolder>() {

    inner class PoetryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val poetryTitle : TextView = itemView.findViewById(R.id.poetryTitle)
        val poetryLine : TextView = itemView.findViewById(R.id.poetryLines)
        val poetryAuthor : TextView = itemView.findViewById(R.id.poetryAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoetryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poetry_list,parent,false)
        return PoetryViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoetryViewHolder, position: Int) {
        val poetryList = poetry[position]
        holder.poetryTitle.text = poetryList.title
        holder.poetryLine.text = poetryList.lines.toString()
        holder.poetryAuthor.text = poetryList.author
    }

    override fun getItemCount(): Int {
        return poetry.size
    }
    fun setPoetry(poetry: List<Poetry>) {
        this.poetry = poetry
        notifyDataSetChanged()
    }
}