package com.neonapps.waypointsdk.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.neonapps.waypointsdk.R

class AdaptiveTaskItemDecoration(private val context: Context): RecyclerView.ItemDecoration() {
    private val itemSpacing: Int = context.resources.getInteger(R.integer.adaptiveItemSpacing)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State

    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: return
        if (position > 0 && position < itemCount-1) {
            outRect.top = itemSpacing
        }else if(position == itemCount-1){
            outRect.top = itemSpacing
            outRect.bottom = itemSpacing
        }
        else {
            outRect.top = itemSpacing
        }
    }
}