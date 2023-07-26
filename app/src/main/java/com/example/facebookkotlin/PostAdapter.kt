package com.example.facebookkotlin

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapter(private val list:List<PostData>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_item,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        val color = Color.parseColor(post.colorCode)
        holder.userImg.backgroundTintList = ColorStateList.valueOf(color)
        holder.tvAuthor.text = post.author
        holder.tvTime.text = post.time
        holder.tvContent.text = post.content
        holder.postImg.backgroundTintList = ColorStateList.valueOf(color)
        holder.tvNumOfLikes.text = post.numOfLikes.toString()
        holder.tvNumOfShares.text = post.numOfShares.toString()
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userImg: ImageView = itemView.findViewById(R.id.user_img)
        var tvAuthor: TextView = itemView.findViewById(R.id.author)
        var tvTime: TextView = itemView.findViewById(R.id.time)
        var tvContent: TextView = itemView.findViewById(R.id.content)
        var postImg: ImageView = itemView.findViewById(R.id.post_img)
        var tvNumOfLikes: TextView = itemView.findViewById(R.id.num_of_likes)
        var tvNumOfShares: TextView = itemView.findViewById(R.id.num_of_shares)
    }
}