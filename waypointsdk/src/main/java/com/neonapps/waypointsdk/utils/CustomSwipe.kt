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
    private val rightSwap: Boolean,
    private val leftSwapText : String,
    private val leftSwapTextColor : Int? = ContextCompat.getColor(context, R.color.White),
    private val leftSwapBackgrounColor : Int? =ContextCompat.getColor(context, R.color.TableRed),
    private val rightSwapText : String,
    private val rightSwapTextColor: Int = ContextCompat.getColor(context, R.color.White),
    private val rightSwapBackgroundColor : Int? = ContextCompat.getColor(context, R.color.TableBluew),
    private val onItemSwipeLeftEnd: (position: Int) -> Unit,
    private val onItemSwipeRightEnd: (position: Int) -> Unit,
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {


    private val leftSwapTextSize = 48f
    private val rightSwapTextSize = 48f
    private val paint = Paint()
    private val leftSwapTextPaint = Paint().apply {
        color = leftSwapTextColor!!
        textSize = leftSwapTextSize
        isAntiAlias = true
    }

    private val rightSwapTextPaint = Paint().apply {
        color = rightSwapTextColor
        textSize = rightSwapTextSize
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
        if (direction == ItemTouchHelper.LEFT) {
            onItemSwipeLeftEnd(position)
        } else if (direction == ItemTouchHelper.RIGHT && rightSwap) {
            onItemSwipeRightEnd(position)
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
            dX < 0 -> {
                backgroundRect = RectF(
                    itemView.right + dX,
                    itemView.top.toFloat(),
                    itemView.right.toFloat(),
                    itemView.bottom.toFloat()
                )
                paint.color = leftSwapBackgrounColor!!
                c.drawRect(backgroundRect, paint)

                drawTextOnBackground(c, backgroundRect, leftSwapText, leftSwapTextPaint)
            }

            dX > 0 -> {
               if(rightSwap){
                   backgroundRect = RectF(
                       itemView.left.toFloat(),
                       itemView.top.toFloat(),
                       itemView.left + dX,
                       itemView.bottom.toFloat()
                   )
                   paint.color = rightSwapBackgroundColor!!
                   c.drawRect(backgroundRect, paint)
                   drawTextOnBackground(c, backgroundRect, rightSwapText, rightSwapTextPaint)
               }

            }

        }
    }

    private fun drawTextOnBackground(c: Canvas, rect: RectF, text: String, textPaint: Paint) {
        val textX = rect.centerX() - (textPaint.measureText(text) / 2)
        val textY = rect.centerY() + (textPaint.textSize / 2)
        c.drawText(text, textX, textY, textPaint)
    }
}