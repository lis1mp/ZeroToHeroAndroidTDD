package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            binding.inputEditText.text?.clear()
            createTextView(text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textList =
            binding.contentLayout.children.map { (it as TextView).text.toString() }.toList()
        outState.putStringArrayList(KEY, ArrayList(textList))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textList = savedInstanceState.getStringArrayList(KEY)
        textList?.forEach { text ->
            createTextView(text)
        }
    }

    fun createTextView(text: String) {
        val textView = TextView(applicationContext).apply {
            setText(text)
        }
        binding.contentLayout.addView(textView)
    }

    companion object {
        private const val KEY = "list"
    }
}