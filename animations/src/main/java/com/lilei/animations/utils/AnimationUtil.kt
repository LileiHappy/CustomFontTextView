package com.lilei.animations.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import com.lilei.animations.type.EnterAnimationTyper
import com.lilei.animations.type.ExitAnimationTyper

/**
 * 动画工具
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com
 * @since 2019-12-31
 */
private val REPEAT_COUNT = 6

fun createAlphaAnimation(view: View, startAlpha: Float, endAlpha: Float, duration: Int):
        ObjectAnimator {
    val alphaAnimation =
        ObjectAnimator.ofFloat(view, "alpha", startAlpha, endAlpha)
    alphaAnimation.duration = duration.toLong()
    return alphaAnimation
}

fun createRotationAnimation(view: View, startAngle: Float, endAngle: Float, duration: Int):
        ObjectAnimator {
    val rotationAnimation =
        ObjectAnimator.ofFloat(view, "rotation", startAngle, endAngle)
    rotationAnimation.duration = duration.toLong()
    rotationAnimation.repeatCount = REPEAT_COUNT
    return rotationAnimation
}

/**
 * 创建进入放缩动画
 * @param view 视图控件
 * @param enterAnimationTyper 进入动画类型
 * @param duration 动画时长
 * @return
 */
fun createEnterScaleAnimation(view: View, enterAnimationTyper: EnterAnimationTyper, duration: Int)
        : AnimatorSet {
    // 放缩起始X值
    var scaleStartX = 0f
    var scaleStartY = 0f
    // 放缩结束X值
    var scaleEndX = 0f
    var scaleEndY = 0f
    when (enterAnimationTyper) {
        // 轻微放大
        EnterAnimationTyper.SCALE_LARGE_LITTLE -> {
            scaleStartX = 0.5f
            scaleStartY = 0.5f
            scaleEndX = 1f
            scaleEndY = 1f
        }
        // 放大
        EnterAnimationTyper.SCALE_LARGE -> {
            scaleEndX = 1f
            scaleEndY = 1f
        }
        // 缩小
        else -> {
            scaleStartX = 3f
            scaleStartY = 3f
            scaleEndX = 1f
            scaleEndY = 1f
        }
    }
    // 实例化动画集
    val animatorSet = AnimatorSet()
    // 宽度一半
    val halfWidth = view.measuredWidth shr 1
    val halfHeight = view.measuredHeight shr 1
    // 设置放缩中心点X坐标
    view.pivotX = halfWidth.toFloat()
    view.pivotY = halfHeight.toFloat()
    // X方向放缩动画
    val scaleXAnimation =
        ObjectAnimator.ofFloat(view, "scaleX", scaleStartX, scaleEndX)
    val scaleYAnimation =
        ObjectAnimator.ofFloat(view, "scaleY", scaleStartY, scaleEndY)
    // 设置动画时长
    animatorSet.duration = duration.toLong()
    // 一起播放动画（水平方向和垂直方向一起放缩）
    animatorSet.playTogether(scaleXAnimation, scaleYAnimation)
    return animatorSet
}

/**
 * 创建退出放缩动画
 * @param view 视图控件
 * @param exitAnimationTyper 退出动画类型
 * @param duration 动画时长
 * @return
 */
fun createExitScaleAnimation(view: View, exitAnimationTyper: ExitAnimationTyper, duration: Int)
        : AnimatorSet {
    val scaleStartX = 1f
    val scaleStartY = 1f
    var scaleEndX = 0f
    var scaleEndY = 0f
    when (exitAnimationTyper) {
        ExitAnimationTyper.SCALE_LARGE_LITTLE -> {
            scaleEndX = 2f
            scaleEndY = 2f
        }
        ExitAnimationTyper.SCALE_LARGE -> {
            scaleEndX = 3f
            scaleEndY = 3f
        }
        else -> {
            scaleEndX = 0f
            scaleEndY = 0f
        }
    }
    val animatorSet = AnimatorSet()
    val halfWidth = view.measuredWidth shr 1
    val halfHeight = view.measuredHeight shr 1
    view.pivotX = halfWidth.toFloat()
    view.pivotY = halfHeight.toFloat()
    val scaleXAnimation =
        ObjectAnimator.ofFloat(view, "scaleX", scaleStartX, scaleEndX)
    val scaleYAnimation =
        ObjectAnimator.ofFloat(view, "scaleY", scaleStartY, scaleEndY)
    animatorSet.duration = duration.toLong()
    animatorSet.playTogether(scaleXAnimation, scaleYAnimation)
    return animatorSet
}

fun createTranslationAnimation(view: View, duration: Int, enterAnimationTyper: EnterAnimationTyper)
        : ObjectAnimator {
    var translationAnimation: ObjectAnimator? = null
    when (enterAnimationTyper) {
        EnterAnimationTyper.TRANSLATE_LEFT -> translationAnimation =
            ObjectAnimator.ofFloat(view, "translationX", 0F, view.measuredWidth.toFloat())
        EnterAnimationTyper.TRANSLATE_RIGHT -> translationAnimation =
            ObjectAnimator.ofFloat(view, "translationX", view.measuredWidth.toFloat(), 0F)
        EnterAnimationTyper.TRANSLATE_TOP -> translationAnimation =
            ObjectAnimator.ofFloat(view, "translationY", 0F, view.measuredHeight.toFloat())
        else -> translationAnimation =
            ObjectAnimator.ofFloat(view, "translationY", view.measuredHeight.toFloat(), 0F)
    }
    translationAnimation!!.duration = duration.toLong()
    return translationAnimation
}
