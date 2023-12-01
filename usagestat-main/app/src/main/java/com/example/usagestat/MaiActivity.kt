package com.example.usagestat

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.usagestat.databinding.ActivityMaiBinding

class MaiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaiBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaiBinding.inflate(layoutInflater)

        val view: View = binding.root
        setContentView(view)

        val showPopupButton: Button = binding.showPopupButton
        val blankScreenButton: Button = binding.blankScreenButton
        val restoreScreenButton: Button = binding.restoreScreenButton
        val timerEditText: EditText = binding.timerEditText
        val startCounterButton: Button = binding.startCounterButton

        showPopupButton.setOnClickListener {
            showPopup()
        }

        blankScreenButton.setOnClickListener {
            startCounter()
        }

        restoreScreenButton.setOnClickListener {
            restoreScreen()
        }

        startCounterButton.setOnClickListener {
            val duration = timerEditText.text.toString().toLong()
            startCounterWithCustomTime(duration)
        }
    }

    private fun showPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Popup Title")
            .setMessage("This is the content of the popup.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun startCounter() {
        val duration = 10L // Default duration if no value entered
        startCounterWithCustomTime(duration)
    }

    private fun restoreScreen() {
        val rootView: View = window.decorView.rootView
        rootView.setBackgroundColor(Color.WHITE)
    }

    private fun startCounterWithCustomTime(duration: Long) {
        val counterTextView: TextView = binding.counterTextView
        counter = 0

        val countDownTimer = object : CountDownTimer(duration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                counter++
                val counterText = resources.getString(R.string.counter_text, counter)
                counterTextView.text = counterText
            }

            override fun onFinish() {
                val counterText = resources.getString(R.string.counter_text, counter)
                counterTextView.text = counterText
                blankScreen()
            }
        }

        countDownTimer.start()
    }

    private fun blankScreen() {
        val rootView: View = window.decorView.rootView
        rootView.setBackgroundColor(Color.BLACK)
    }
}
