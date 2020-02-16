package com.lilei.animations.delegate

import android.view.View

/**
 * 动画策略接口，主要是为了统一
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */

interface AnimationStrategy {
    companion object {
        val DURATION = 500
        val DURATION_ALPHA = 500
        val DURATION_SCALE = 600
        val DURATION_ROTATION = 1200
        val TRANSPARENT = 0F
        val OPACITY = 1F
        val NO_ANGLE = 0F
        val ROUND_ANGLE = 360F
    }
    /**
     * 启动透明动画
     * @param view 视图控件
     */
    fun startAlphaAnimation(view: View?)

    /**
     *
     * @param view
     */
    fun startScaleLargeLittleAnimation(view: View?)

    fun startScaleLargeAnimation(view: View?)

    fun startScaleSmallAnimation(view: View?)

    fun startRotationAnimation(view: View?)

    fun startTranlationFromLeft(view: View?)

    fun startTranslationFromRight(view: View?)

    fun startTranslationFromTop(view: View?)

    fun startTranslationFromBottom(view: View?)
}
