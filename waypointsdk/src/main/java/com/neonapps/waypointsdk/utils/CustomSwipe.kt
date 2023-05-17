package com.neonapps.waypointsdk.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.neonapps.waypointsdk.R

class CustomSwipe(
    context: Context,
    private val onItemSwipeLeftEnd: (position: Int) -> Unit,
    private val onItemSwipeRightEnd: (position: Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    private val deleteText = context.getString(R.string.done)
    private val archiveText = context.getString(R.string.cancel)
    private val deleteTextColor = ContextCompat.getColor(context, R.color.White)
    private val archiveTextColor = ContextCompat.getColor(context, R.color.White)
    private val deleteBackgroundColor = ContextCompat.getColor(context, R.color.TableGreen)
    private val archiveBackgroundColor = ContextCompat.getColor(context, R.color.TableBluew)
    private val deleteTextSize = 48f // Adjust text size as needed
    private val archiveTextSize = 48f // Adjust text size as needed
    private val paint = Paint()
    private val deleteTextPaint = Paint().apply {
        color = deleteTextColor
        textSize = deleteTextSize
        isAntiAlias = true
    }

    private val archiveTextPaint = Paint().apply {
        color = archiveTextColor
        textSize = archiveTextSize
        isAntiAlias = true
    }


    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition

        when (direction) {
            ItemTouchHelper.LEFT -> onItemSwipeLeftEnd(position)
            ItemTouchHelper.RIGHT -> onItemSwipeRightEnd(position)
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val itemView = viewHolder.itemView
        val isCanceled = dX == 0f && !isCurrentlyActive

        val backgroundRect: RectF


        when {
            isCanceled -> return
            dX < 0  -> {
                backgroundRect = RectF(
                    itemView.right + dX,
                    itemView.top.toFloat(),
                    itemView.right.toFloat(),
                    itemView.bottom.toFloat()
                )
                paint.color = deleteBackgroundColor
                c.drawRect(backgroundRect, paint)

                drawTextOnBackground(c, backgroundRect, deleteText, deleteTextPaint)
            }

            dX > 0 -> {
                backgroundRect = RectF(
                    itemView.left.toFloat(),
                    itemView.top.toFloat(),
                    itemView.left + dX,
                    itemView.bottom.toFloat()
                )
                paint.color = archiveBackgroundColor
                c.drawRect(backgroundRect, paint)
                drawTextOnBackground(c, backgroundRect, archiveText, archiveTextPaint)

            }

        }
    }

    private fun drawTextOnBackground(c: Canvas, rect: RectF, text: String, textPaint: Paint) {
        val textX = rect.centerX() - (textPaint.measureText(text) / 2)
        val textY = rect.centerY() + (textPaint.textSize / 2)
        c.drawText(text, textX, textY, textPaint)
    }
}