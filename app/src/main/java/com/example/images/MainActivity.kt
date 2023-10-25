package com.example.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private var index = 0
    private var currentColor = "green"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val nextButton: Button = findViewById(R.id.next_button)
        val prevButton: Button = findViewById(R.id.prev_button)
        val switch: Switch = findViewById(R.id.switch1)
        val layout: ConstraintLayout = findViewById(R.id.mainLayout)
        val myTextView: TextView = findViewById(R.id.myTextView)
        val slider: SeekBar = findViewById(R.id.seekBar)

        switch.setOnClickListener {
            if(switch.isChecked)
            {
                layout.setBackgroundColor(resources.getColor(R.color.green))
            }
            else
            {
                layout.setBackgroundColor(resources.getColor(R.color.blue))
            }

        }
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                myTextView.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }
        })

        val images = mutableListOf(
            R.drawable.motylek,
            R.drawable.tiger,
            R.drawable.moon
        )

        nextButton.setOnClickListener {
            if(index < images.size-1)
            {
                index++
            }
            else{
                index = 0
            }

            imageView.setImageResource(images[index])
        }

        prevButton.setOnClickListener {
            if(index > 0)
            {
                index--
            }
            else
            {
                index = images.size - 1
            }

            imageView.setImageResource(images[index])
        }
    }
}