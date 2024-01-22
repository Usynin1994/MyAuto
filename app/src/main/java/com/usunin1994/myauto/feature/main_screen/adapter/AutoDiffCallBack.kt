package com.usunin1994.myauto.feature.main_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.usunin1994.myauto.feature.main_screen.domain.Auto

class AutoDiffCallBack (
    private val oldList: List<Auto>,
    private val newList: List<Auto>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPlaylist = oldList[oldItemPosition]
        val newPlaylist = newList[newItemPosition]
        return oldPlaylist.entryDate == newPlaylist.entryDate
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPlaylist = oldList[oldItemPosition]
        val newPlaylist = newList[newItemPosition]
        return oldPlaylist == newPlaylist
    }
}