package com.javiermtz.codechallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javiermtz.codechallenge.R.layout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
  }
}
