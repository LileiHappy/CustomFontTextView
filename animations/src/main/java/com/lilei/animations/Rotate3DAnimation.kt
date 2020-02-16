package com.lilei.animations

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

/**
 * 动画管理者
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */
class Rotate3DAnimation(
    /** 旋转标志  */
    private val mRotate3DTyper: Rotate3DTyper, private val mDuration: Int
) : Animation() {
    private var mCenterX: Float = 0.toFloat()
    private var mCenterY: Float = 0.toFloat()
    private var mDepthZ: Float = 0.toFloat()
    private var isComing: Boolean = false
    private val mCamera: Camera

    enum class Rotate3DTyper {
        /** 沿X轴旋转  */
        ROTATE_X_AXIS,
        /** 沿Y轴旋转  */
        ROTATE_Y_AXIS,
        /** 沿Z轴旋转  */
        ROTATE_Z_AXIS
    }

    init {
        mCamera = Camera()
    }

    fun setComing(isComing: Boolean) {
        this.isComing = isComing
    }

    fun setDepthZ(depthZ: Float) {
        mDepthZ = depthZ
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCenterX = (width shr 1).toFloat()
        mCenterY = (height shr 1).toFloat()
        duration = mDuration.toLong()
        interpolator = LinearInterpolator()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        super.applyTransformation(interpolatedTime, t)
        val matrix = t.matrix
        val camera = mCamera
        // 保存当前镜头
        camera.save()
        // 沿Z轴平移镜头，平移的效果是产生视图由远到近或由近到远
        camera.translate(0f, 0f, mDepthZ * if (isComing) 1 - interpolatedTime else interpolatedTime)
        when (mRotate3DTyper) {
            // 沿X轴旋转
            Rotate3DAnimation.Rotate3DTyper.ROTATE_X_AXIS -> camera.rotateX(ROUND_ANGLE * interpolatedTime)
            Rotate3DAnimation.Rotate3DTyper.ROTATE_Y_AXIS -> camera.rotateY(ROUND_ANGLE * interpolatedTime)
            else -> camera.rotateZ(ROUND_ANGLE * interpolatedTime)
        }
        // 应用变换
        camera.getMatrix(matrix)
        // 恢复
        // 以视图中心旋转
        matrix.preTranslate(-mCenterX, -mCenterY)
        matrix.postTranslate(mCenterX, mCenterY)
        camera.restore()
    }

    companion object {
        /** 周角  */
        private val ROUND_ANGLE = 360
    }
}
