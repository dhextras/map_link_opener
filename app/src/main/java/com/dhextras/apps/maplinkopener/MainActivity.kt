package com.dhextras.apps.maplinkopener

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dhextras.apps.maplinkopener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }

    private fun setupUi() {
        binding.clearButton.setOnClickListener {
            binding.inputEditText.setText("")
        }

        binding.openLinkButton.setOnClickListener {
            val inputText = binding.inputEditText.text.toString()
            if (inputText.startsWith("https://maps.app.goo.gl/") || inputText.startsWith("https://www.google.com/maps/")) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(inputText))
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "Error opening link: $e", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Invalid Google Maps link", Toast.LENGTH_SHORT).show()
            }
        }
    }
}