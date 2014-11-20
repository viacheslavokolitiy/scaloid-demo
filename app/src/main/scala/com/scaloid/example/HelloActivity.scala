package com.scaloid.example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.{MenuItem, Menu}
import android.widget.{Toast, TextView}

class HelloActivity extends Activity {
  protected override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my)
    startActivity(new Intent(HelloActivity.this, classOf[CameraActivity]))
  }


  override def onStart(): Unit = {
    super.onStart()
  }

  protected override def onCreateOptionsMenu(menu: Menu): Boolean = {
    val inflater = getMenuInflater
    inflater.inflate(R.menu.my, menu)
    return true
  }
}