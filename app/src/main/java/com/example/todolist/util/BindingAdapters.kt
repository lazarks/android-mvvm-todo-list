package com.example.todolist.util

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat

@BindingAdapter("setPriority")
fun setPriority(view: TextView, priority: Int){
    when(priority){
        0 -> {
            view.text = "High Priority"
            view.setTextColor(Color.RED)
        }
        1 -> {
            view.text = "Medium Priority"
            view.setTextColor(Color.BLUE)
        }
        2 -> {
            view.text = "Low Priority"
            view.setTextColor(Color.GREEN)
        }
    }
}

@BindingAdapter("setTimestamp")
fun setTimestamp(view: TextView, timestamp: Long){
    view.text = DateFormat.getInstance().format(timestamp)
}