package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.count.Count
import ru.easycode.zerotoheroandroidtdd.state.UiState

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 4, 0)

    private lateinit var state: UiState
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        incrementButton.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply(textView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            state = count.decrement(textView.text.toString())
            state.apply(textView, incrementButton, decrementButton)
        }

        if (savedInstanceState == null) {
            state = count.initial(textView.text.toString())
            state.apply(textView, incrementButton, decrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable(KEY) as UiState

        state.apply(textView, incrementButton, decrementButton)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}