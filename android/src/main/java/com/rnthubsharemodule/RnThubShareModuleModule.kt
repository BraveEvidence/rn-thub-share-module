package com.rnthubsharemodule

import android.content.Intent
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.io.File
import java.io.IOException

class RnThubShareModuleModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  private var shareSuccessCallback: Callback? = null
  private var shareFailureCallback: Callback? = null

  override fun getName(): String {
    return "RnThubShareModule"
  }

  @ReactMethod
  fun shareText(text: String, successCallback: Callback, failureCallback: Callback) {

    shareSuccessCallback = successCallback
    shareFailureCallback = failureCallback

    val sendIntent: Intent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(Intent.EXTRA_TEXT, text)
      type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    reactContext.startActivity(shareIntent)
  }

  @ReactMethod
  fun shareImage(uri: String,extension: String, successCallback: Callback, failureCallback: Callback) {

    shareSuccessCallback = successCallback
    shareFailureCallback = failureCallback

    try {
      val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_STREAM, uri)
        type = extension
      }
      reactContext.startActivity(Intent.createChooser(shareIntent, "Common services"))

    } catch (e: IOException) {
      e.printStackTrace()
      shareFailureCallback?.invoke(e.message.toString())
    }

  }




}
