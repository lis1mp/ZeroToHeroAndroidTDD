package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.count.Count

class MainActivity : AppCompatActivity() {
    private val counter = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val button = findViewById<Button>(R.id.incrementButton)

        button.setOnClickListener {
            textView.text = counter.increment(textView.text.toString())
        }
    }
}