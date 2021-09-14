package com.example.luckyticketkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        const val MAX_NUMBER_OF_DIGITS = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun fnCheckTicket(view: View) {

        val num = findViewById<EditText>(R.id.etTicketNumber).text.toString()
        val picture = findViewById<ImageView>(R.id.light)
        val pictureGreen = getDrawable(R.drawable.green_light)
        val pictureRed = getDrawable(R.drawable.red_light)

        if (num.length == MAX_NUMBER_OF_DIGITS) {

                val result = num.toCharArray().map { it.toString().toInt() }

                if (result[0] + result[1] + result[2] == result[3] + result[4] + result[5]) {
                    picture.setImageDrawable(pictureGreen)
                } else {
                    picture.setImageDrawable(pictureRed)
                }

        } else {
            Toast.makeText(applicationContext,"Enter 6 digits", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
