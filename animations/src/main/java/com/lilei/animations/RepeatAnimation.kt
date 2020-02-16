package com.lilei.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.Animation
import com.lilei.animations.delegate.OnWaveProgressListener

/**
 * 重复动画
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */
class RepeatAnimation private constructor() {

    private object AnimationRepeatHandler {
        val sRepeatAnimation = RepeatAnimation()
    }

    fun startTrembleAnimation(view: View) {

    }

    fun startRotationAnimation(view: View?) {
        if (view == null) {
            return
        }
        val halfWidth = view.measuredWidth
        val halfHeight = view.measuredHeight
        view.pivotX = halfWidth.toFloat()
        view.pivotY = halfHeight.toFloat()
        val rotationAnimation = ObjectAnimator.ofFloat(view, "rotation",
            0F, 360F)
        rotationAnimation.setDuration(DURATION.toLong())
        rotationAnimation.setRepeatCount(ValueAnimator.INFINITE)
        rotationAnimation.start()
    }

    fun startFlipAnimation(view: View?) {
        if (view == null) {
            return
        }
        val flipAnimation = Rotate3DAnimation(
            Rotate3DAnimation.Rotate3DTyper.ROTATE_Y_AXIS,
            DURATION_WAVE
        )
        flipAnimation.setRepeatCount(Animation.INFINITE)
        view.startAnimation(flipAnimation)
    }

    fun startJumpAnimation(view: View?) {
        if (view == null) {
            return
        }
        val jumpAnimation = ObjectAnimator.ofFloat(view, "translationY",
            200F, 0F)
        jumpAnimation.setDuration(DURATION_JUMP.toLong())
        jumpAnimation.setRepeatCount(ValueAnimator.INFINITE)
        jumpAnimation.start()
    }

    fun startHeartbeatAnimation(view: View?) {
        if (view == null) {
            return
        }
        val animatorSet = AnimatorSet()
        val scaleX = ObjectAnimator.ofFloat(
            view, "scaleX", 0.4f,
            1.5f
        )
        scaleX.repeatCount = ValueAnimator.INFINITE
        val scaleY = ObjectAnimator.ofFloat(
            view, "scaleY", 0.4f,
            1.5f
        )
        scaleY.repeatCount = ValueAnimator.INFINITE
        animatorSet.playTogether(scaleX, scaleY)
        animatorSet.duration = DURATION.toLong()
        animatorSet.start()
    }

    fun startTwinkleAnimation(view: View?) {
        if (view == null) {
            return
        }
        val twinkleAnimation = ObjectAnimator.ofFloat(view, "alpha",
            0F, 1F
        )
        twinkleAnimation.setDuration(DURATION_JUMP.toLong())
        twinkleAnimation.setRepeatCount(ValueAnimator.INFINITE)
        twinkleAnimation.start()
    }

    fun startWaveAnimation(waveLength: Float, listener: OnWaveProgressListener?) {
        val waveAnimation = ValueAnimator.ofFloat(0F, waveLength)
        waveAnimation.duration = DURATION_WAVE.toLong()
        waveAnimation.repeatCount = ValueAnimator.INFINITE
        waveAnimation.addUpdateListener { animation ->
            if (listener != null) {
                listener!!.onWaveProgress(animation.animatedValue as Float)
            }
        }
        waveAnimation.start()
    }

    companion object {
        private val DURATION = 500
        private val DURATION_JUMP = 300
        private val DURATION_WAVE = 600

        val instance: RepeatAnimation
            get() = AnimationRepeatHandler.sRepeatAnimation
    }
}
