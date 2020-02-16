package com.lilei.animations


import android.view.View
import com.lilei.animations.delegate.AnimationStrategy
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_ALPHA
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_ROTATION
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_SCALE
import com.lilei.animations.delegate.AnimationStrategy.Companion.OPACITY
import com.lilei.animations.delegate.AnimationStrategy.Companion.TRANSPARENT
import com.lilei.animations.type.ExitAnimationTyper
import com.lilei.animations.utils.createAlphaAnimation
import com.lilei.animations.utils.createExitScaleAnimation
import com.lilei.animations.utils.createRotationAnimation

/**
 * 退出动画
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-30
 */
class ExitAnimation private constructor() : AnimationStrategy {

    private object ExitAnimationHandler {
        val sExitAnimation = ExitAnimation()
    }

    override fun startAlphaAnimation(view: View?) {
        if (view != null) {
            val alphaAnimation = createAlphaAnimation(view, TRANSPARENT, OPACITY, DURATION_ALPHA)
            alphaAnimation.start()
        }
    }

    override fun startScaleLargeLittleAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createExitScaleAnimation(view, ExitAnimationTyper.SCALE_LARGE_LITTLE,
                DURATION_SCALE)
            animatorSet.playTogether(createAlphaAnimation(view, OPACITY, TRANSPARENT, DURATION_SCALE))
            animatorSet.start()
        }
    }

    override fun startScaleLargeAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createExitScaleAnimation(view, ExitAnimationTyper.SCALE_LARGE,
                DURATION_SCALE)
            animatorSet.playTogether(createAlphaAnimation(view, OPACITY, TRANSPARENT, DURATION_SCALE))
            animatorSet.start()
        }
    }

    override fun startScaleSmallAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createExitScaleAnimation(view, ExitAnimationTyper.SCALE_SMALL,
                DURATION_SCALE)
            animatorSet.playTogether(createAlphaAnimation(view, OPACITY, TRANSPARENT, DURATION_SCALE))
            animatorSet.start()
        }
    }

    override fun startRotationAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createExitScaleAnimation(view, ExitAnimationTyper.SCALE_SMALL,
                DURATION_ROTATION)
            val rotationAnimation = createRotationAnimation(view, 0F, 360F, DURATION_ROTATION)
            animatorSet.playTogether(rotationAnimation)
            animatorSet.start()
        }
    }

    override fun startTranlationFromLeft(view: View?) {

    }

    override fun startTranslationFromRight(view: View?) {

    }

    override fun startTranslationFromTop(view: View?) {

    }

    override fun startTranslationFromBottom(view: View?) {

    }

    companion object {
        val instance: ExitAnimation
            get() = ExitAnimationHandler.sExitAnimation
    }
}
