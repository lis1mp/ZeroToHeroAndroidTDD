package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun update(
        titleTextView: TextView,
        progressBar: ProgressBar,
        button: Button
    )

    data object ShowProgress : UiState {

        override fun update(titleTextView: TextView, progressBar: ProgressBar, button: Button) {
            titleTextView.visibility = View.GONE
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    data object ShowData : UiState {

        override fun update(titleTextView: TextView, progressBar: ProgressBar, button: Button) {
            titleTextView.visibility = View.VISIBLE
            button.isEnabled = true
            progressBar.visibility = View.GONE
        }
    }
}