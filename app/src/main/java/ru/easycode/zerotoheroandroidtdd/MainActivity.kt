package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.rootLayout)

        binding.inputEditText.addTextChangedListener { text ->
            binding.actionButton.isEnabled = text.toString().length >= 3
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            binding.titleTextView.text = text
            binding.inputEditText.text?.clear()
        }
    }
}