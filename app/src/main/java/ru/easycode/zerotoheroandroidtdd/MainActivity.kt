package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.contains

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)
        val removeButton = findViewById<Button>(R.id.removeButton)

        removeButton.setOnClickListener {
            linearLayout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, !linearLayout.contains(textView))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(KEY)) {
            linearLayout.removeView(textView)
        }
    }

    companion object {
        private const val KEY = "isTextViewRemoved"
    }
}