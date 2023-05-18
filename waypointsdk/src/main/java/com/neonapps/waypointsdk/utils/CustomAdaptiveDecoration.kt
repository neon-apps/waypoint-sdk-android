package com.neonapps.waypointsdk.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomAdaptiveDecoration(private val spanCount: Int = 1, private val spacingHorizontal: Int, private val spacingVertical: Int,private val includeEdge: Boolean = true) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            outRect.left = spacingVertical - column * spacingVertical / spanCount
            outRect.right = (column + 1) * spacingVertical / spanCount

            if (position < spanCount) {
                outRect.top = spacingHorizontal
            }
            outRect.bottom = spacingHorizontal
        } else {
            outRect.left = column * spacingHorizontal / spanCount
            outRect.right = spacingHorizontal - (column + 1) * spacingHorizontal / spanCount
            if (position >= spanCount) {
                outRect.top = spacingHorizontal
            }
        }
    }
}
