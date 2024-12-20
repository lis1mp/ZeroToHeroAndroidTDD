package ru.easycode.zerotoheroandroidtdd

import android.view.View
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)

    data object ShowProgress : UiState {

        override fun update(binding: ActivityMainBinding) {
            binding.titleTextView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            binding.actionButton.isEnabled = false
        }
    }

    data class ShowData(private val text: String) : UiState {

        override fun update(binding: ActivityMainBinding) {
            binding.titleTextView.visibility = View.VISIBLE
            binding.titleTextView.text = text
            binding.progressBar.visibility = View.GONE
            binding.actionButton.isEnabled = true
        }
    }
}
