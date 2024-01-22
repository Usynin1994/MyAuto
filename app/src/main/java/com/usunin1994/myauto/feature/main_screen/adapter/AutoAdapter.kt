package com.usunin1994.myauto.feature.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.usunin1994.myauto.databinding.AutoCardBinding
import com.usunin1994.myauto.feature.main_screen.domain.Auto

class AutoAdapter (
    private val listener: ClickListener
) : RecyclerView.Adapter<AutoViewHolder> () {

    internal var autoList = ArrayList<Auto>()
        set(newValue) {
            val diffCallBack = AutoDiffCallBack(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallBack)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }
    fun clearTracks () {
        autoList = ArrayList()
    }

    fun interface ClickListener {
        fun onClick(track: Auto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoViewHolder {
        return AutoViewHolder(
            AutoCardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) {
        holder.bind(autoList[position], listener)
    }

    override fun getItemCount(): Int {
        return autoList.size
    }
}