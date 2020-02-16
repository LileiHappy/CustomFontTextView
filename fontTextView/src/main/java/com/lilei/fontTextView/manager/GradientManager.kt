package com.lilei.fontTextView.manager

import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.SweepGradient
import com.lilei.fontTextView.StyleFontSetting
import com.lilei.fontTextView.type.gradient.LightScanTyper
import com.lilei.fontTextView.type.gradient.LinearGradientDirectionTyper
import com.lilei.fontTextView.type.gradient.RadialTyper
import com.lilei.fontTextView.type.gradient.SweepTyper


/**
 * 渐变梯度管理者
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-28
 */
class GradientManager
/**
 * 构造函数
 * @param styleFontSetting 配置构建者
 */
    (
    /** 配置构建者  */
    private val mStyleFontSetting: StyleFontSetting
) {
    /** 矩阵变换  */
    private var mMatrix: Matrix? = null

    /** 颜色值数组  */
    private var mColors: IntArray? = null
    /** 位置数组  */
    private var mPositions: FloatArray? = null

    /** 渐变梯度  */
    /**
     * 获取渐变梯度
     * @return
     */
    var gradient: Shader? = null
        private set
    /** 移动的渐变梯度  */
    /**
     * 获取移动光影
     * @return
     */
    var moveGradient: Shader? = null
        private set

    /** 线性扫描当前移动到的位置  */
    private var mMovePosition: Int = 0
    /** 当前移动到的角度  */
    private var mSweepAngle: Int = 0
    /** 当前移动到的半径  */
    private var mRadialRadius: Int = 0

    /** 视图宽度  */
    private var mWidth: Int = 0
    /** 视图高度  */
    private var mHeight: Int = 0

    /**
     * 生成线性梯度渐变
     */
    fun createLinearGradient() {
        if (gradient == null && mStyleFontSetting.linearGradientDirectionTyper != null) {
            // 起始X坐标
            var startX = 0f
            var startY = 0f
            // 结束X坐标
            var endX = 0f
            var endY = 0f
            when (mStyleFontSetting.linearGradientDirectionTyper) {
                // 从左到右渐变
                LinearGradientDirectionTyper.LEFT_TO_RIGHT -> {
                    startX = 0f
                    startY = 0f
                    endX = mWidth.toFloat()
                    endY = 0f
                }
                LinearGradientDirectionTyper.RIGHT_TO_LEFT -> {
                    startX = mWidth.toFloat()
                    startY = 0f
                    endX = 0f
                    endY = 0f
                }
                // 从上到下渐变
                LinearGradientDirectionTyper.TOP_TO_BOTTOM -> {
                    startX = 0f
                    startY = 0f
                    endX = 0f
                    endY = mHeight.toFloat()
                }
                LinearGradientDirectionTyper.BOTTOM_TO_TOP -> {
                    startX = 0f
                    startY = mHeight.toFloat()
                    endX = 0f
                    endY = 0f
                }
            }
            gradient = if (mStyleFontSetting.isSimpleColors)
                LinearGradient(
                    startX,
                    startY,
                    endX,
                    endY,
                    mStyleFontSetting.startColor,
                    mStyleFontSetting.endColor,
                    mStyleFontSetting.tileMode
                )
            else
                LinearGradient(
                    startX, startY, endX, endY, mStyleFontSetting.colors!!,
                    mStyleFontSetting.positions, mStyleFontSetting.tileMode
                )
        }
    }

    /**
     * 生成光影
     */
    private fun createMoveLinearGradient() {
        if (moveGradient == null && mStyleFontSetting.lightScanTyper != null) {
            // 光线的起始和结束坐标
            var startX = 0f
            var startY = 0f
            var endX = 0f
            var endY = 0f
            when (mStyleFontSetting.lightScanTyper) {
                // 从左到右扫描
                LightScanTyper.MOVE_LEFT_TO_RIGHT -> {
                    startX = 0f
                    startY = 0f
                    endX = mWidth.toFloat()
                    endY = 0f
                }
                LightScanTyper.MOVE_RIGHT_TO_LEFT -> {
                    startX = mWidth.toFloat()
                    startY = 0f
                    endX = 0f
                    endY = 0f
                }
                LightScanTyper.MOVE_TOP_TO_BOTTOM -> {
                    startX = 0f
                    startY = 0f
                    endX = 0f
                    endY = mHeight.toFloat()
                }
                LightScanTyper.MOVE_BOTTOM_TO_TOP -> {
                    startX = 0f
                    startY = mHeight.toFloat()
                    endX = 0f
                    endY = 0f
                }
            }
            // 水平移动标志
            val isHorizontalMove =
                LightScanTyper.MOVE_LEFT_TO_RIGHT === mStyleFontSetting.lightScanTyper
                        || LightScanTyper.MOVE_RIGHT_TO_LEFT === mStyleFontSetting.lightScanTyper
            // 倾斜光束
            if (mStyleFontSetting.isTiltLight) {
                // 水平扫描
                if (isHorizontalMove) {
                    // 为了让光影倾斜，则将宽度变为原来的一半
                    endX /= 2f
                } else {
                    endY /= 2f
                }
            }
            //            caculateCurrentMovePosition(isHorizontalMove);
            // 实例化光影颜色值数组
            if (mColors == null) {
                mColors = if (mStyleFontSetting.isOneLight)
                    intArrayOf(0x00ffffff, 0x73ffffff, 0x00ffffff)
                else
                    intArrayOf(0x00ffffff, 0x73ffffff, 0x00ffffff, -0x66000001, 0x00ffffff)
            }
            // 实例化位置数组
            if (mPositions == null) {
                mPositions = if (mStyleFontSetting.isOneLight)
                    floatArrayOf(0f, 0.5f, 1f)
                else
                    floatArrayOf(0.2f, 0.35f, 0.45f, 0.5f, 0.8f)
            }
            // 实例化光影
            moveGradient = LinearGradient(
                startX,
                startY,
                endX,
                endY,
                mColors!!,
                mPositions,
                Shader.TileMode.CLAMP
            )
        }
    }

    /**
     * 计算当前光影所在位置
     * @param isHorizontalMove 水平移动标志
     */
    private fun caculateCurrentMovePosition(isHorizontalMove: Boolean) {
        // 有扫描光影
        if (mStyleFontSetting.lightScanTyper != null) {
            // 移动的间距
            val moveStep = (if (isHorizontalMove) mWidth else mHeight) shr 8
            when (mStyleFontSetting.lightScanTyper) {
                // 从左往右移动
                LightScanTyper.MOVE_LEFT_TO_RIGHT -> {
                    mMovePosition += moveStep
                    if (mMovePosition > mWidth shl 1) {
                        mMovePosition = -mWidth
                    }
                }
                LightScanTyper.MOVE_RIGHT_TO_LEFT -> {
                    mMovePosition -= moveStep
                    if (mMovePosition < -mWidth) {
                        mMovePosition = mWidth shl 1
                    }
                }
                LightScanTyper.MOVE_TOP_TO_BOTTOM -> {
                    mMovePosition += moveStep
                    if (mMovePosition > mHeight shl 1) {
                        mMovePosition = -mHeight
                    }
                }
                LightScanTyper.MOVE_BOTTOM_TO_TOP -> {
                    mMovePosition -= moveStep
                    if (mMovePosition < -mHeight) {
                        mMovePosition = mHeight shl 1
                    }
                }
            }
        }
    }

    /**
     * 设置宽度
     * @param width 宽度
     */
    fun setWidth(width: Int) {
        mWidth = width
    }

    /**
     * 设置高度
     * @param height 高度
     */
    fun setHeight(height: Int) {
        mHeight = height
    }

    /**
     * 光影移动
     */
    fun move() {
        // 生成光影
        createMoveLinearGradient()
        // 重置变换矩阵
        resetMoveMatrix()
        if (mMatrix != null) {
            val isHorizontalMove =
                LightScanTyper.MOVE_LEFT_TO_RIGHT === mStyleFontSetting.lightScanTyper
                        || LightScanTyper.MOVE_RIGHT_TO_LEFT === mStyleFontSetting.lightScanTyper
            // 计算当前光影的位置
            caculateCurrentMovePosition(isHorizontalMove)
            // 水平移动，更新当前的位置
            if (isHorizontalMove) {
                mMatrix!!.setTranslate(mMovePosition.toFloat(), 0f)
            } else {
                mMatrix!!.setTranslate(0f, mMovePosition.toFloat())
            }
            // 设置变换
            if (moveGradient != null) {
                moveGradient!!.setLocalMatrix(mMatrix)
            }
        }
    }

    /**
     * 生成扇形渐变
     */
    fun createSweepGradient() {
        if (gradient == null) {
            gradient = if (mStyleFontSetting.isSimpleColors)
                SweepGradient(
                    (mWidth shr 1).toFloat(),
                    (mHeight shr 1).toFloat(),
                    mStyleFontSetting.startColor,
                    mStyleFontSetting.endColor
                )
            else
                SweepGradient(
                    (mWidth shr 1).toFloat(), (mHeight shr 1).toFloat(), mStyleFontSetting.colors!!,
                    mStyleFontSetting.positions
                )
        }
    }

    /**
     *
     */
    fun sweepMove() {
        resetMoveMatrix()
        if (mMatrix != null) {
            if (mStyleFontSetting.sweepTyper === SweepTyper.CLOCKWISE) {
                mSweepAngle += 5
                if (mSweepAngle >= 360) {
                    mSweepAngle = 0
                }
            } else {
                mSweepAngle -= 5
                if (mSweepAngle <= 0) {
                    mSweepAngle = 360
                }
            }
            //            int[] colors = {Color.WHITE, Color.WHITE};
            //            float[] positions = {mSweepAngle / 360f, (mSweepAngle + 5) / 360f};
            //            SweepGradient sweepLight = new SweepGradient(mWidth >> 1, mHeight >> 1, colors,
            //                    positions);
            mMatrix!!.setRotate(
                mSweepAngle.toFloat(),
                (mWidth shr 1).toFloat(),
                (mHeight shr 1).toFloat()
            )
            if (gradient != null) {
                gradient!!.setLocalMatrix(mMatrix)
            }
        }
    }

    fun createRadialGradient() {
        if (gradient == null) {
            val maxSize = Math.max(mWidth, mHeight)
            gradient = if (mStyleFontSetting.isSimpleColors)
                RadialGradient(
                    (mWidth shr 1).toFloat(),
                    (mHeight shr 1).toFloat(),
                    (maxSize shr 1).toFloat(),
                    mStyleFontSetting.startColor,
                    mStyleFontSetting.endColor,
                    mStyleFontSetting.tileMode
                )
            else
                RadialGradient(
                    (mWidth shr 1).toFloat(),
                    (mHeight shr 1).toFloat(),
                    (maxSize shr 1).toFloat(),
                    mStyleFontSetting.colors!!,
                    mStyleFontSetting.positions,
                    mStyleFontSetting.tileMode
                )
        }
    }

    fun radialMove() {
        resetMoveMatrix()
        if (mMatrix != null) {
            val maxSizeHalf = Math.max(mWidth, mHeight) shr 1
            if (RadialTyper.RADIAL_OUT === mStyleFontSetting.rdialTyper) {
                mRadialRadius += 10
                if (mRadialRadius >= maxSizeHalf) {
                    mRadialRadius = 0
                }
            } else {
                mRadialRadius -= 10
                if (mRadialRadius <= 0) {
                    mRadialRadius = maxSizeHalf
                }
            }
            mMatrix!!.setScale(
                maxSizeHalf.toFloat(),
                maxSizeHalf.toFloat(),
                (mWidth shr 1).toFloat(),
                (mHeight shr 1).toFloat()
            )
            //            mGradient = isSimpleColors ? new RadialGradient(mWidth >> 1, mHeight >> 1, maxSize >> 1,
            //                    mStartColor, mEndColor, mTileMode) : new RadialGradient(mWidth >> 1, mHeight >> 1,
            //                    maxSize >> 1, mColors, mPositions, mTileMode);
            if (gradient != null) {
                gradient!!.setLocalMatrix(mMatrix)
                //            mPaint.setShader(mGradient);
            }
        }
    }

    private fun resetMoveMatrix() {
        if (mMatrix == null) {
            mMatrix = Matrix()
        }
        mMatrix!!.reset()
    }
}
