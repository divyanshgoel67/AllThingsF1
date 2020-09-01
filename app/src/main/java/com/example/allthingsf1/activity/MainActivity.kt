package com.example.allthingsf1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.allthingsf1.R

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.AppTheme_CustomBarTheme)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Change default action bar to custom bar
    supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
    supportActionBar?.setDisplayShowCustomEnabled(true)
    supportActionBar?.setCustomView(R.layout.custom_toolbar);
  }
}
