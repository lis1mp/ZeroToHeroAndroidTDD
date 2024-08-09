package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import ru.easycode.zerotoheroandroidtdd.count.Count
import ru.easycode.zerotoheroandroidtdd.count.UiState

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 4)
    private var state: UiState = UiState.Base("0")

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply(textView, button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        state.apply(textView, button)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}