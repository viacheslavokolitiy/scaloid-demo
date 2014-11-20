package com.scaloid.example

import android.app.Activity
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.hardware.Camera
import android.os.Bundle
import android.view.{SurfaceHolder, SurfaceView}

import scala.beans.BeanProperty

class CameraActivity extends Activity with OnClickListener with SurfaceHolder.Callback {
  @BeanProperty
  var camera: Camera=_
  @BeanProperty
  var surfaceView: SurfaceView=_
  @BeanProperty
  var surfaceHolder: SurfaceHolder=_
  private var inPreview: Boolean = false

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_camera)
    surfaceView = findViewById(R.id.camera_surface).asInstanceOf[SurfaceView]
    surfaceHolder = surfaceView.getHolder
    surfaceHolder.addCallback(this)
    surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    surfaceHolder.setFixedSize(getWindow.getWindowManager
      .getDefaultDisplay.getWidth, getWindow.getWindowManager
      .getDefaultDisplay.getHeight)
  }

  override def onClick(p1: DialogInterface, p2: Int): Unit = {

  }

  override def surfaceCreated(p1: SurfaceHolder): Unit = {
    try {
      camera.setPreviewDisplay(surfaceHolder)
    } catch {
      case t: Throwable => println(t.printStackTrace())
    }
  }

  override def surfaceChanged(p1: SurfaceHolder, p2: Int, p3: Int, p4: Int): Unit = {

  }

  override def surfaceDestroyed(p1: SurfaceHolder): Unit = {

  }

  override def onResume(): Unit = {
    super.onResume()
    camera = Camera.open
  }

  override def onPause(): Unit = {
    if(inPreview){
      camera.stopPreview()
    }

    camera.release()
    camera = null
    inPreview = false
    super.onPause()
  }
}