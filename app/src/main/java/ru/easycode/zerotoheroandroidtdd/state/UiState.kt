package ru.easycode.zerotoheroandroidtdd.state

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, incrementButton: Button, decrementButton: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
            textView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
            textView.text = text
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
            textView.text = text
        }
    }
}