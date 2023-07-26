package com.example.facebookkotlin

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StoryAdapter(private val list:List<StoryData>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.story_item,parent,false)
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = list[position]
        holder.storyImg.backgroundTintList = ColorStateList.valueOf(Color.parseColor(story.storyColorCode))
        holder.userImg.backgroundTintList = ColorStateList.valueOf(Color.parseColor(story.userColorCode))
        holder.author.text = story.author
    }

    class StoryViewHolder(itemView: View): ViewHolder(itemView) {
        val storyImg:ImageView = itemView.findViewById(R.id.story_img)
        val userImg:ImageView = itemView.findViewById(R.id.user_img)
        val author:TextView = itemView.findViewById(R.id.author)
    }
}