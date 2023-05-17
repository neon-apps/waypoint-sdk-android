package com.neonapps.waypointsdk.utils

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.neonapps.waypointsdk.R
import com.neonapps.waypointsdk.databinding.CustomTaskSnackbarBinding

class SnackbarTakeItBack {
    companion object{
        fun createSnackBar(
            view: View,
            content: String,
            duration: Int,
            snackBarAction: ()-> Unit
        ){
            val snack =  Snackbar.make(view,content,duration)
            val customSnackView = View.inflate(view.context, R.layout.custom_task_snackbar, null)
            val binding = CustomTaskSnackbarBinding.bind(customSnackView)
            binding.snackBarText.text = content
            binding.snackBarAction.setOnClickListener {
                snackBarAction.invoke()
                snack.dismiss()

            }
            var snackView = snack.view as ViewGroup
            snackView.removeAllViews()
            snackView.addView(binding.root)
            snack.view.setPadding(0,0,0,0)
            snack.setBackgroundTint(
                ContextCompat.getColor(
                    view.context,
                    android.R.color.transparent
                )
            )
            snack.show()
        }
        fun scrollToTakeBack(recyclerView: RecyclerView,
                             position : Int,
                             itemCount : Int,){
            if(position == 0){
                recyclerView.smoothScrollToPosition(0)

            }else if(position == itemCount-1){
                recyclerView.smoothScrollToPosition(itemCount-1)

            }else{
                recyclerView.smoothScrollToPosition(position)
            }

        }
    }

}