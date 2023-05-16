package com.neonapps.waypointsdk.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdaptiveTaskItemDecoration: RecyclerView.ItemDecoration() {
    private val itemSpacing: Int = 50

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