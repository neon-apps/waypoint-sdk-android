package com.neonapps.waypointsdk.utils

import android.content.Context
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContextCompat
import com.neonapps.waypointsdk.R

object CustomPopUpMenu {
    fun showCustomPopupMenu(
        view: View,
        context: Context,
        itemList: HashMap<String, String>,
        customClickListener: (item: String) -> Unit
    ) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.inflate(R.menu.custom_menu)
        itemList.forEach {

            when (it.key) {
                "blue" -> {
                    val spanString = SpannableString(it.value)
                    spanString.setSpan(
                        ForegroundColorSpan(
                            ContextCompat.getColor(
                                context,
                                R.color.TableBluew
                            )
                        ), 0, spanString.length, 0
                    )
                    popupMenu.menu.add(spanString)
                }
                "red" -> {
                    val spanString = SpannableString(it.value)
                    spanString.setSpan(
                        ForegroundColorSpan(
                            ContextCompat.getColor(
                                context,
                                R.color.TableRed
                            )
                        ), 0, spanString.length, 0
                    )
                    popupMenu.menu.add(spanString)
                }
                else -> {
                    val spanString = SpannableString(it.value)
                    spanString.setSpan(
                        ForegroundColorSpan(
                            ContextCompat.getColor(
                                context,
                                R.color.Black
                            )
                        ), 0, spanString.length, 0
                    )
                    popupMenu.menu.add(spanString)
                }
            }

        }

        popupMenu.setOnMenuItemClickListener { menuItem ->
            customClickListener(menuItem.title.toString())
            true
        }
        popupMenu.show()
    }
}