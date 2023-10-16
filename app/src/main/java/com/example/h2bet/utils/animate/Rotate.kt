package com.example.h2bet.utils.animate

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation

class Rotate(val start: (Boolean) -> Unit, val end: (Float) -> Unit) {
    fun rotateWheel(view: View) {
        val randomAngle = (Math.random() * 360).toFloat()

        val rotateAnimation = RotateAnimation(
            0f, randomAngle + 10 * 360,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotateAnimation.duration = 2000
        rotateAnimation.interpolator = DecelerateInterpolator()
        rotateAnimation.fillAfter = true

        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                start(false)
            }

            override fun onAnimationEnd(animation: Animation?) {
                end(randomAngle)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        view.startAnimation(rotateAnimation)
    }
}