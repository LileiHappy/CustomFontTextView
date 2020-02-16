package com.lilei.animations.manager

import com.lilei.animations.EnterAnimation
import com.lilei.animations.ExitAnimation
import com.lilei.animations.RepeatAnimation
import com.lilei.animations.delegate.OnWaveProgressListener
import com.lilei.animations.type.EnterAnimationTyper
import com.lilei.animations.type.ExitAnimationTyper
import com.lilei.animations.type.RepeatAnimationTyper

import android.view.View

/**
 * 动画管理者
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */
class AnimationManager
/**
 * 私有化动画管理者构造函数
 */
private constructor() {

    /** 进入动画实现工具  */
    private var mEnterAnimation: EnterAnimation? = null
    /** 退出动画实现工具  */
    private var mExitAnimation: ExitAnimation? = null
    /** 重复动画实现工具  */
    private var mRepeatAnimation: RepeatAnimation? = null

    init {
        // 实例化动画实现工具
        mEnterAnimation = EnterAnimation.instance
        mExitAnimation = ExitAnimation.instance
        mRepeatAnimation = RepeatAnimation.instance
    }

    /**
     * 静态内部类句柄
     */
    private object AnimationManagerHandler {
        val sAnimationManager = AnimationManager()
    }

    /**
     * 启动进入动画
     * @param view 视图控件
     * @param enterAnimationTyper 进入动画类型
     */
    fun startEnterAnimation(view: View, enterAnimationTyper: EnterAnimationTyper) {
        when (enterAnimationTyper) {
            EnterAnimationTyper.ALPHA -> mEnterAnimation!!.startAlphaAnimation(view)
            EnterAnimationTyper.KARAOKE -> mEnterAnimation!!.startKaraokeAnimation()
            EnterAnimationTyper.SCALE_LARGE_LITTLE -> mEnterAnimation!!.startScaleLargeLittleAnimation(
                view)
            EnterAnimationTyper.SCALE_LARGE -> mEnterAnimation!!.startScaleLargeAnimation(view)
            EnterAnimationTyper.SCALE_SMALL -> mEnterAnimation!!.startScaleSmallAnimation(view)
            EnterAnimationTyper.ROTATION -> mEnterAnimation!!.startRotationAnimation(view)
            EnterAnimationTyper.WIPE_OUT_IN -> {
            }
            EnterAnimationTyper.TRANSLATE_LEFT -> mEnterAnimation!!.startTranlationFromLeft(view)
            EnterAnimationTyper.TRANSLATE_RIGHT -> mEnterAnimation!!.startTranslationFromRight(view)
            EnterAnimationTyper.TRANSLATE_TOP -> mEnterAnimation!!.startTranslationFromTop(view)
            EnterAnimationTyper.TRANSLATE_BOTTOM -> mEnterAnimation!!.startTranslationFromBottom(
                view)
        }
    }

    /**
     * 启动退出动画
     * @param view 视图控件
     * @param exitAnimationTyper 退出动画类型
     */
    fun startExitAnimation(view: View, exitAnimationTyper: ExitAnimationTyper) {
        when (exitAnimationTyper) {
            ExitAnimationTyper.ALPHA -> mExitAnimation!!.startAlphaAnimation(view)
            ExitAnimationTyper.SCALE_LARGE_LITTLE -> mExitAnimation!!.startScaleLargeLittleAnimation(
                view)
            ExitAnimationTyper.SCALE_LARGE -> mExitAnimation!!.startScaleLargeAnimation(view)
            ExitAnimationTyper.SCALE_SMALL -> mExitAnimation!!.startScaleSmallAnimation(view)
            ExitAnimationTyper.ROTATION -> mExitAnimation!!.startRotationAnimation(view)
            ExitAnimationTyper.TRANSLATE_LEFT -> mExitAnimation!!.startTranlationFromLeft(view)
        }
    }

    /**
     * 启动重复动画
     * @param view 视图控件
     * @param repeatAnimationTyper 重复动画类型
     */
    fun startRepeatAnimation(view: View, repeatAnimationTyper: RepeatAnimationTyper) {
        when (repeatAnimationTyper) {
            RepeatAnimationTyper.TREMBLE -> mRepeatAnimation!!.startTrembleAnimation(view)
            RepeatAnimationTyper.ROTATION -> mRepeatAnimation!!.startRotationAnimation(view)
            RepeatAnimationTyper.FLIP -> mRepeatAnimation!!.startFlipAnimation(view)
            RepeatAnimationTyper.JUMP -> mRepeatAnimation!!.startJumpAnimation(view)
            RepeatAnimationTyper.HEART_BEAT -> mRepeatAnimation!!.startHeartbeatAnimation(view)
            RepeatAnimationTyper.TWINKLE -> mRepeatAnimation!!.startTwinkleAnimation(view)
            RepeatAnimationTyper.WAVE -> {
            }
        }
    }

    fun startWaveAnimation(waveLength: Float, listener: OnWaveProgressListener) {
        mRepeatAnimation!!.startWaveAnimation(waveLength, listener)
    }

    /**
     * 清除
     */
    fun clear() {
        mEnterAnimation = null
        mExitAnimation = null
        mRepeatAnimation = null
    }

    companion object {

        /**
         * 获取动画管理者实例
         * @return
         */
        val instance: AnimationManager
            get() = AnimationManagerHandler.sAnimationManager
    }
}
