package com.neonapps.waypointsdk.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.neonapps.waypointsdk.R

class SwipeToDeleteCallback(
    private val context: Context,
    private val onItemSwipedLeft: (position: Int) -> Unit,
    private val onItemSwipedRight: (position: Int) -> Unit,
    private val onItemSwipeLeftEnd: (position: Int) -> Unit,
    private val onItemSwipeRightEnd: (position: Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    private val deleteText = context.getString(R.string.done)
    private val archiveText = context.getString(R.string.cancel)
    private val takeItBackText = context.getString(R.string.takeItBack)
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

    private val deleteIcon: Drawable? = ContextCompat.getDrawable(context, R.drawable.take_it_back_icon)
    private val iconMargin = 16 // Adjust icon margin as needed

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
            ItemTouchHelper.LEFT -> onItemSwipedLeft(position)
            ItemTouchHelper.RIGHT -> onItemSwipedRight(position)
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
        val position = viewHolder.adapterPosition
        val itemView = viewHolder.itemView
        val isCanceled = dX == 0f && !isCurrentlyActive

        val backgroundRect: RectF


        when {
            isCanceled -> return
            dX < 0 && dX > -itemView.width -> { // Swiping to the left (delete)
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
            dX <= -itemView.width ->{
                backgroundRect = RectF(
                    itemView.right + dX,
                    itemView.top.toFloat(),
                    itemView.right.toFloat(),
                    itemView.bottom.toFloat()
                )
                paint.color = ContextCompat.getColor(context, R.color.TableRed)
                c.drawRect(backgroundRect, paint)
                drawTextWithIconOnBackground(c, backgroundRect, takeItBackText, deleteTextPaint, deleteIcon!!)
                onItemSwipeLeftEnd(position)
            }
            dX > 0 && dX < itemView.width  -> { // Swiping to the right (archive)
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
            dX >= itemView.width  -> { // Swiping to the right (archive)
                backgroundRect = RectF(
                    itemView.left.toFloat(),
                    itemView.top.toFloat(),
                    itemView.left + dX,
                    itemView.bottom.toFloat()
                )
                paint.color = ContextCompat.getColor(context, R.color.TableRed)
                c.drawRect(backgroundRect, paint)
                drawTextWithIconOnBackground(c, backgroundRect, takeItBackText, deleteTextPaint, deleteIcon!!)
                onItemSwipeRightEnd(position)



            }

        }
    }

    private fun drawTextOnBackground(c: Canvas, rect: RectF, text: String, textPaint: Paint) {
        val textX = rect.centerX() - (textPaint.measureText(text) / 2)
        val textY = rect.centerY() + (textPaint.textSize / 2)
        c.drawText(text, textX, textY, textPaint)
    }

    private fun drawTextWithIconOnBackground(
        c: Canvas,
        rect: RectF,
        text: String,
        textPaint: Paint,
        icon: Drawable
    ) {
        // Calculate text position
        val textX = rect.centerX() - (textPaint.measureText(text) / 2)
        val textY = rect.centerY() + (textPaint.textSize / 2)

        // Calculate icon position

        val iconLeft = textX - 70f
        val iconTop = textY - 40f
        val iconRight = textX - 15f
        val iconBottom = iconTop + 50f

        // Draw icon
        icon.setBounds(iconLeft.toInt(), iconTop.toInt(), iconRight.toInt(), iconBottom.toInt())
        icon.draw(c)

        // Draw text
        c.drawText(text, textX, textY, textPaint)
    }


}