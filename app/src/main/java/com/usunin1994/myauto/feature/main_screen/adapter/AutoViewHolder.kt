package com.usunin1994.myauto.feature.main_screen.adapter

import android.os.Environment
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.usunin1994.myauto.R
import com.usunin1994.myauto.databinding.AutoCardBinding
import com.usunin1994.myauto.feature.main_screen.domain.Auto
import java.io.File

class AutoViewHolder (
    private val binding: AutoCardBinding
): RecyclerView.ViewHolder (binding.root) {

    private val filePath = File(itemView.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), DIRECTORY)

    fun bind (model: Auto, listener: AutoAdapter.ClickListener) {
        binding.textBrand.text = model.brand
        binding.textEngine.text = model.engine
        binding.textEntryDate.text = model.entryDate
        binding.textYear.text = model.year

        val file = model.image?.let { File(filePath, it.toUri().lastPathSegment) }
        Glide.with(itemView)
            .load(file)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .into(binding.autoImage)


        itemView.setOnClickListener {
            listener.onClick(model)
        }
    }

    companion object {
        const val DIRECTORY = "autolist"
    }
}