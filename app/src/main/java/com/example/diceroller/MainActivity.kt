package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Want to minimize calls to findViewById as much as possible so extract
    // lateinit allows android to declare and initialize non null variables in on create
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        diceImage = binding.diceImage
        binding.rollButton.setOnClickListener {
            rollDice()
        }
//        setContentView(R.layout.activity_main)
//        val rollButton = findViewById<Button>(R.id.roll_button)
//        rollButton.setOnClickListener {
//            rollDice()
//        }
//        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

}