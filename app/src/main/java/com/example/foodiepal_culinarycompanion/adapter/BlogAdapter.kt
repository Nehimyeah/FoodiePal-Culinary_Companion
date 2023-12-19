package com.example.foodiepal_culinarycompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.model.Blog

class BlogAdapter(private val blogs: MutableList<Blog>) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blog_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogAdapter.ViewHolder, position: Int) {
        val blog = blogs[position]
        holder.title.text = blog.title
        holder.author.text = blog.writer
        holder.date.text = blog.time.toString()
        val contentSnippet = if (blog.content.length > 100) {
            blog.content.substring(0, 100) + "..."
        } else {
            blog.content
        }
        holder.contentSnippet.text = contentSnippet
        holder.comments.text = "Comments ${blog.comments.size}"
    }

    override fun getItemCount() = blogs.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val author: TextView
        val date: TextView
        val contentSnippet: TextView
        val comments: TextView

        init {
            title = itemView.findViewById(R.id.blogTitleTextView)
            author = itemView.findViewById(R.id.authorTextView)
            date = itemView.findViewById(R.id.dateTextView)
            contentSnippet = itemView.findViewById(R.id.contentSnippetTextView)
            comments = itemView.findViewById(R.id.commentSectionTextView)
        }
    }
}