package com.example.thebook.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

import com.example.thebook.MainActivity
import com.example.thebook.R

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable


class BodyFragment : Fragment() {

    private val TAG = "BodyFragment"

    private var activity: MainActivity? = null
    private var webView: WebView? = null
    private val baseUri = "file:///android_asset/"
    private val extension = ".html"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.body_fragment, container, false)
        activity = getActivity() as MainActivity?

        webView = view.findViewById(R.id.webView)
        webView!!.setBackgroundColor(0x00000000)

        if (activity!!.singleTitle != null) {
            activity!!.singleTitle?.subscribe(observerPref)
        }
        return view
    }

    private val observerPref = object : SingleObserver<String> {
        override fun onSubscribe(d: Disposable) {

        }
        override fun onSuccess(s: String) {
            setWebView(baseUri + s + extension)
        }
        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView(uri: String) {
        webView!!.loadUrl(uri)
        val webSettings = webView!!.settings
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.javaScriptEnabled = true
    }
}
