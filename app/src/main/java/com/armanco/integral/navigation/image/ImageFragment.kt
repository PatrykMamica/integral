package com.armanco.integral.navigation.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.armanco.integral.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import kotlinx.android.synthetic.main.fragment_image.*


class ImageFragment: Fragment(R.layout.fragment_image) {

    private var mInterstitialAd: InterstitialAd? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInterstitialAd()
        arguments?.getInt(IMAGE_KEY)?.let { photoView?.setImageResource(it) }
    }

    private fun showInterstitialAd() {
        mInterstitialAd = InterstitialAd(activity)
        mInterstitialAd?.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        val adRequest = AdRequest.Builder().build()
        mInterstitialAd?.loadAd(adRequest)
        mInterstitialAd?.adListener = object : AdListener() {
            override fun onAdLoaded() {
                mInterstitialAd?.show()
            }
            override fun onAdFailedToLoad(adError: LoadAdError) {}
            override fun onAdOpened() {}
            override fun onAdClicked() {}
            override fun onAdLeftApplication() {}
            override fun onAdClosed() {}
        }
    }

    companion object {
        const val IMAGE_KEY = "image"
    }
}