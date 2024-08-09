package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.actionButton)

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE

            button.postDelayed({
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
                button.isEnabled = true
            }, 3000L)
        }
    }
}