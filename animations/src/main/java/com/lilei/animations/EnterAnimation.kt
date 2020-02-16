package com.lilei.animations

import com.lilei.animations.delegate.AnimationStrategy
import com.lilei.animations.type.EnterAnimationTyper
import com.lilei.animations.utils.createAlphaAnimation
import com.lilei.animations.utils.createEnterScaleAnimation
import com.lilei.animations.utils.createRotationAnimation
import com.lilei.animations.utils.createTranslationAnimation

import android.graphics.Canvas
import android.text.TextUtils
import android.view.View
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_ALPHA
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_ROTATION
import com.lilei.animations.delegate.AnimationStrategy.Companion.DURATION_SCALE
import com.lilei.animations.delegate.AnimationStrategy.Companion.NO_ANGLE
import com.lilei.animations.delegate.AnimationStrategy.Companion.OPACITY
import com.lilei.animations.delegate.AnimationStrategy.Companion.ROUND_ANGLE
import com.lilei.animations.delegate.AnimationStrategy.Companion.TRANSPARENT

/**
 * 进入动画
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-30
 */
class EnterAnimation private constructor() : AnimationStrategy {

    private object AnimationInHandler {
        val sEnterAnimation = EnterAnimation()
    }

    override fun startAlphaAnimation(view: View?) {
        if (view != null) {
            val alphaAnimation = createAlphaAnimation(view, TRANSPARENT, OPACITY, DURATION_ALPHA)
            alphaAnimation.start()
        }
    }

    fun startKaraokeAnimation() {

    }

    override fun startScaleLargeLittleAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createEnterScaleAnimation(view, EnterAnimationTyper.SCALE_LARGE_LITTLE,
                DURATION_SCALE)
            animatorSet.start()
        }
    }

    override fun startScaleLargeAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createEnterScaleAnimation(view, EnterAnimationTyper.SCALE_LARGE,
                DURATION_SCALE)
            animatorSet.start()
        }
    }

    override fun startScaleSmallAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createEnterScaleAnimation(view, EnterAnimationTyper.SCALE_SMALL,
                DURATION_SCALE)
            animatorSet.start()
        }
    }

    override fun startRotationAnimation(view: View?) {
        if (view != null) {
            val animatorSet = createEnterScaleAnimation(view, EnterAnimationTyper.SCALE_LARGE_LITTLE,
                DURATION_ROTATION)
            val rotationAnimation = createRotationAnimation(view, NO_ANGLE, ROUND_ANGLE,
                DURATION_ROTATION)
            animatorSet.playTogether(rotationAnimation)
            animatorSet.start()
        }
    }

    override fun startTranlationFromLeft(view: View?) {
        if (view != null) {
            val translationAnimation = createTranslationAnimation(view, DURATION,
                EnterAnimationTyper.TRANSLATE_LEFT)
            translationAnimation.start()
        }
    }

    override fun startTranslationFromRight(view: View?) {
        if (view != null) {
            val translationAnimation = createTranslationAnimation(view, DURATION,
                EnterAnimationTyper.TRANSLATE_RIGHT)
            translationAnimation.start()
        }
    }

    override fun startTranslationFromTop(view: View?) {
        if (view != null) {
            val translationAnimation = createTranslationAnimation(view, DURATION,
                EnterAnimationTyper.TRANSLATE_TOP)
            translationAnimation.start()
        }
    }

    override fun startTranslationFromBottom(view: View?) {
        if (view != null) {
            val translationAnimation = createTranslationAnimation(view, DURATION,
                EnterAnimationTyper.TRANSLATE_BOTTOM)
            translationAnimation.start()
        }
    }

    //    private void startTranslationAnimation(View view, EnterAnimationTyper enterAnimationTyper) {
    //        ObjectAnimator translationAnimation = null;
    //        switch (enterAnimationTyper) {
    //            case TRANSLATE_LEFT:
    //                translationAnimation = ObjectAnimator.ofFloat(view, "translationX",
    //                        0, view.getMeasuredWidth());
    //                break;
    //            case TRANSLATE_RIGHT:
    //                translationAnimation = ObjectAnimator.ofFloat(view, "translationX",
    //                        view.getMeasuredWidth(), 0);
    //                break;
    //            case TRANSLATE_TOP:
    //                translationAnimation = ObjectAnimator.ofFloat(view, "translationY",
    //                        0, view.getMeasuredHeight());
    //                break;
    //            default:
    //                translationAnimation = ObjectAnimator.ofFloat(view, "translationY",
    //                        view.getMeasuredHeight(), 0);
    //        }
    //        translationAnimation.setDuration(DURATION);
    //        translationAnimation.start();
    //    }

    fun startTypingAnimation(canvas: Canvas?, text: String) {
        if (canvas == null || TextUtils.isEmpty(text)) {
            return
        }
    }

    companion object {
        val instance: EnterAnimation
            get() = AnimationInHandler.sEnterAnimation
    }
}
