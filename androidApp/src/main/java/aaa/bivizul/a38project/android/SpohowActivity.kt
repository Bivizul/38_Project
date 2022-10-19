@file:Suppress("DEPRECATION")

package aaa.bivizul.a38project.android

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWDOR
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWKOR
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.*
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import im.delight.android.webview.AdvancedWebView

class SpohowActivity : ComponentActivity(), AdvancedWebView.Listener {

    lateinit var spohowwv: AdvancedWebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spohow)

        val spohowurl = intent.getStringExtra(SPOHOWKOR) ?: SPOHOWDOR

        spohowwv = findViewById<View>(R.id.spohowawv) as AdvancedWebView

        spohowwv.webViewClient = WebViewClient()
        spohowwv.webChromeClient = MyChromeClient()

        spohowwv.setListener(this, this)
        spohowwv.setMixedContentAllowed(false)

        setSettings()

        if (savedInstanceState == null) {
            spohowwv.post {
                kotlin.run { spohowwv.loadUrl(spohowurl) }
            }
        }

        spohowwv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                spohowwv.canGoBack()
            ) {
                spohowwv.goBack()
                return@OnKeyListener true
            }
            false
        })

    }

    @SuppressLint("NewApi")
    override fun onResume() {
        super.onResume()
        spohowwv.onResume()
    }

    @SuppressLint("NewApi")
    override fun onPause() {
        spohowwv.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        spohowwv.onDestroy()
        super.onDestroy()
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        spohowwv.onActivityResult(requestCode, resultCode, intent)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (!spohowwv.onBackPressed()) {
            return
        }
        finishAndRemoveTask()
        System.exit(0)
    }


    override fun onPageStarted(url: String?, favicon: Bitmap?) {}

    override fun onPageFinished(url: String?) {}

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {}

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?,
    ) {
    }

    override fun onExternalPageRequest(url: String?) {}

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val spohowws = spohowwv.settings
        spohowws.javaScriptEnabled = true
        spohowws.loadWithOverviewMode = true
        spohowws.allowFileAccess = true
        spohowws.domStorageEnabled = true
        spohowws.builtInZoomControls = true
        spohowws.displayZoomControls = false
        spohowws.useWideViewPort = true
        spohowws.setSupportZoom(true)
        spohowws.setCacheMode(WebSettings.LOAD_NO_CACHE)
        spohowws.userAgentString = spohowws.userAgentString.replace("; wv", "")
    }

    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        spohowwv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams,
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }

        private var spohowCustomView: View? = null
        private var spohowCustomViewCallback: CustomViewCallback? = null
        private var spohowOriginalOrientation = 0
        private var spohowOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (spohowCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@SpohowActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@SpohowActivity.window.decorView as FrameLayout).removeView(spohowCustomView)
            spohowCustomView = null
            this@SpohowActivity.window.decorView.systemUiVisibility =
                spohowOriginalSystemUiVisibility
            this@SpohowActivity.requestedOrientation = spohowOriginalOrientation
            spohowCustomViewCallback!!.onCustomViewHidden()
            spohowCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?,
        ) {
            if (spohowCustomView != null) {
                onHideCustomView()
                return
            }
            spohowCustomView = paramView
            spohowOriginalSystemUiVisibility =
                this@SpohowActivity.window.decorView.systemUiVisibility
            spohowOriginalOrientation = this@SpohowActivity.requestedOrientation
            spohowCustomViewCallback = paramCustomViewCallback
            (this@SpohowActivity.window.decorView as FrameLayout).addView(
                spohowCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@SpohowActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}