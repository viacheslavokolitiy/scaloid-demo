package com.scaloid.example

import android.app.Activity
import android.os.Bundle
import android.view.{MenuItem, Menu}
import android.widget.{Toast, TextView}

class HelloActivity extends Activity {
  protected override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my)
    val helloView = findViewById(R.id.text_hello).asInstanceOf[TextView]
    helloView.setText("Hello from scaloid")
  }

  protected override def onCreateOptionsMenu(menu: Menu): Boolean = {
    val inflater = getMenuInflater
    inflater.inflate(R.menu.my, menu)
    return true
  }
}