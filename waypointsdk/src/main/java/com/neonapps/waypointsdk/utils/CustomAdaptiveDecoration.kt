package com.neonapps.waypointsdk.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class CustomAdaptiveDecoration(
    private val spanCount: Int = 1,
    private val spacingHorizontal: Int,
    private val spacingVertical: Int,

    ) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount
        val itemCount = parent.adapter!!.itemCount
        if (spanCount == 1) {
            outRect.top = spacingVertical
            if (position == itemCount - 1) {
                outRect.bottom = spacingVertical
            }
            outRect.left = spacingHorizontal
            outRect.right = spacingHorizontal
        } else {
            outRect.left = spacingVertical - column * spacingVertical / spanCount
            outRect.right = (column + 1) * spacingVertical / spanCount

            if (position < spanCount) {
                outRect.top = spacingHorizontal
            }
            outRect.bottom = spacingHorizontal
        }
    }
}